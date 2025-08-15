import './App.css';
import NumberInputForm from './components/NumberInputForm';
import TreeDisplay from './components/TreeDisplay';
import PreviousTrees from './components/PreviousTrees';
import { useState } from 'react';

function App() {
    const [currentTree, setCurrentTree] = useState(null);
    const [error, setError] = useState(null);

    return (
        <div className="App">
            <h1>Binary Search Tree Visualizer 🌳</h1>

            {error && (
                <div style={{ color: 'red', marginBottom: '1rem' }}>
                    ⚠️ Error: {error}
                </div>
            )}

            <NumberInputForm
                onTreeGenerated={setCurrentTree}
                onError={setError}
            />

            <TreeDisplay tree={currentTree} />

            <PreviousTrees onError={setError} />
        </div>
    );
}

export default App;
