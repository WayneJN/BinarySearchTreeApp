import React, { useState } from 'react';
import GraphicalTreeNode from './GraphicalTreeNode';
import '../css/TreeDisplay.css';

function TreeNode({ node }) {
    if (!node) return null;

    return (
        <div className="tree-node">
            <div className="tree-node-box">
                {node.value}
            </div>
            <div className="tree-node-children">
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
        <div className="tree-display">
            {/* ✅ Header container */}
            <div className="tree-display-header">
                <h3>Binary Search Tree</h3>
                <div className="view-buttons-row">
                    <button onClick={() => setView('tree')}>🌳 Tree View</button>
                    <button onClick={() => setView('traversal')}>📜 Traversal View</button>
                    <button onClick={() => setView('raw')}>🧾 Raw JSON View</button>
                    <button onClick={() => setView('graphical')}>🖼️ Graphical View</button>
                </div>
            </div>

            {view === 'tree' && parsedTree ? (
                <TreeNode node={parsedTree} />
            ) : view === 'traversal' && parsedTraversal ? (
                <ul>
                    {parsedTraversal.map((val, idx) => (
                        <li key={idx}>{val}</li>
                    ))}
                </ul>
            ) : view === 'raw' && tree.treeJson ? (
                <pre>{tree.treeJson}</pre>
            ) : view === 'graphical' && parsedTree ? (
                <div className="graphical-container">
                    <svg width="100%" height="500">
                        <GraphicalTreeNode
                            node={parsedTree}
                            x={400}
                            y={40}
                            depth={0}
                            spacing={200}
                        />
                    </svg>
                </div>
            ) : (
                <p>No data available for this view.</p>
            )}
        </div>
    );
}

export default TreeDisplay;
