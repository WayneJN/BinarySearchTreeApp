import { useEffect, useState } from 'react';
import axios from 'axios';
import Spinner from './Spinner';
import Toast from './Toast';

function PreviousTrees({ onError }) {
  const [trees, setTrees] = useState([]);
  const [loading, setLoading] = useState(false);
  const [toast, setToast] = useState(null);

  useEffect(() => {
    const fetchTrees = async () => {
      setLoading(true);
      setToast(null);

      try {
        const response = await axios.get('http://localhost:8080/api/bst/previous-trees');
        setTrees(response.data);
        setToast({ type: 'success', message: 'Previous trees loaded!' });
      } catch (error) {
        onError?.(error.message);
        setToast({ type: 'error', message: 'Failed to load previous trees.' });
      } finally {
        setLoading(false);
      }
    };

    fetchTrees();
  }, [onError]);

  return (
      <div>
        <h2>Previous Trees</h2>
        {loading && <Spinner />}
        {toast && <Toast type={toast.type} message={toast.message} />}
        <ul>
          {trees.map((tree, index) => (
              <li key={index}>{JSON.stringify(tree)}</li>
          ))}
        </ul>
      </div>
  );
}

export default PreviousTrees;
