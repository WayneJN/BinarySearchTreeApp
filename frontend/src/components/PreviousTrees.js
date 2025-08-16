import React from 'react';
import '../css/PreviousTrees.css';


function PreviousTrees({ trees, setCurrentTree }) {
  if (!trees || trees.length === 0) return <p>No previous trees saved.</p>;

  return (
      <div>
        <h3>🌲 Previous Trees</h3>
        <ul style={{ listStyleType: 'none', padding: 0 }}>
          {trees.map((tree, index) => (
              <li key={index} style={{
                marginBottom: '10px',
                padding: '10px',
                border: '1px solid #ccc',
                borderRadius: '5px',
                backgroundColor: '#f9f9f9'
              }}>
                <strong>Tree #{index + 1}</strong>
                <div style={{ marginTop: '5px' }}>
                  <button onClick={() => setCurrentTree(tree)}>👁️ View</button>
                </div>
              </li>
          ))}
        </ul>
      </div>
  );
}

export default PreviousTrees;
