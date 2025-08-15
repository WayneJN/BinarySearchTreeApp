import React, { useState } from 'react';

function TreeNode({ node }) {
    if (!node) return null;
    return (
        <div style={{ margin: '10px', textAlign: 'center' }}>
            <div>{node.value}</div>
            <div style={{ display: 'flex', justifyContent: 'center' }}>
                <TreeNode node={node.left} />
                <TreeNode node={node.right} />
            </div>
        </div>
    );
}

function TreeDisplay({ tree }) {
    const [view, setView] = useState('tree');

    if (!tree || !tree.treeJson) return <p>No tree to display yet.</p>;

    let parsedTree = null;
    let parsedTraversal = null;

    try {
        parsedTree = JSON.parse(tree.treeJson);
    } catch (e) {
        console.error("Invalid tree JSON:", e);
    }

    try {
        parsedTraversal = tree.traversalJson ? JSON.parse(tree.traversalJson) : null;
    } catch (e) {
        console.error("Invalid traversal JSON:", e);
    }

    return (
        <div>
            <h3>Binary Search Tree</h3>
            <div style={{ marginBottom: '10px' }}>
                <button onClick={() => setView('tree')}>Tree View</button>
                <button onClick={() => setView('traversal')}>Traversal View</button>
            </div>

            {view === 'tree' && parsedTree ? (
                <TreeNode node={parsedTree} />
            ) : view === 'traversal' && parsedTraversal ? (
                <ul>
                    {parsedTraversal.map((val, idx) => (
                        <li key={idx}>{val}</li>
                    ))}
                </ul>
            ) : (
                <p>No data available for this view.</p>
            )}
        </div>
    );
}

export default TreeDisplay;
