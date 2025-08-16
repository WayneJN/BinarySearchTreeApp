import './App.css';
import NumberInputForm from './components/NumberInputForm';
import TreeDisplay from './components/TreeDisplay';
import PreviousTrees from './components/PreviousTrees';
import { useState } from 'react';

function App() {
    const [currentTree, setCurrentTree] = useState(null);
    const [savedTrees, setSavedTrees] = useState([]);
    const [error, setError] = useState(null);

    const handleTreeGenerated = (newTree) => {
        setCurrentTree(newTree);
        setSavedTrees(prev => [newTree, ...prev]); // Add to history
        setError(null);
    };

    return (
        <div className="App">
            <h1>Binary Search Tree Visualizer 🌳</h1>

            {error && (
                <div style={{ color: 'red', marginBottom: '1rem' }}>
                    ⚠️ Error: {error}
                </div>
            )}

            <NumberInputForm
                onTreeGenerated={handleTreeGenerated}
                onError={setError}
            />

            <TreeDisplay tree={currentTree} />

            <PreviousTrees
                trees={savedTrees}
                setCurrentTree={setCurrentTree}
            />
        </div>
    );
}

export default App;
