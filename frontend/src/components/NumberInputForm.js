import { useState } from 'react';
import axios from 'axios';
import Spinner from './Spinner';
import Toast from './Toast';

function NumberInputForm({ onTreeGenerated, onError }) {
    const [numbers, setNumbers] = useState('');
    const [loading, setLoading] = useState(false);
    const [toast, setToast] = useState(null);

    const handleSubmit = async (e) => {
        e.preventDefault();
        setLoading(true);
        setToast(null);

        try {
            const response = await axios.post('http://localhost:8080/api/bst/process-numbers', {
                numbers: numbers.split(',').map(n => parseInt(n.trim()))
            });

            onTreeGenerated(response.data);
            setToast({ type: 'success', message: 'Tree generated successfully!' });
        } catch (error) {
            onError?.(error.message);
            setToast({ type: 'error', message: 'Failed to generate tree.' });
        } finally {
            setLoading(false);
        }
    };

    return (
        <div>
            <form onSubmit={handleSubmit}>
                <input
                    type="text"
                    placeholder="Enter numbers (e.g. 3,6,10,14)"
                    value={numbers}
                    onChange={(e) => setNumbers(e.target.value)}
                />
                <button type="submit" disabled={loading}>Generate Tree</button>
            </form>

            {loading && <Spinner />}
            {toast && <Toast type={toast.type} message={toast.message} />}
        </div>
    );
}

export default NumberInputForm;
