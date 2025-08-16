import React from 'react';
import '../css/GraphicalTreeNode.css';


function GraphicalTreeNode({ node, x, y, depth, spacing }) {
    if (!node) return null;

    const nodeRadius = 20;
    const verticalSpacing = 80;
    const horizontalSpacing = spacing / 2;

    const leftX = x - horizontalSpacing;
    const rightX = x + horizontalSpacing;
    const childY = y + verticalSpacing;

    // Debug log to confirm rendering
    console.log("Rendering node:", node.value, "at", x, y);

    return (
        <>
            {/* Lines to children */}
            {node.left && (
                <line
                    x1={x}
                    y1={y}
                    x2={leftX}
                    y2={childY}
                    stroke="black"
                />
            )}
            {node.right && (
                <line
                    x1={x}
                    y1={y}
                    x2={rightX}
                    y2={childY}
                    stroke="black"
                />
            )}

            {/* Current node */}
            <circle cx={x} cy={y} r={nodeRadius} fill="#90ee90" stroke="black" />
            <text
                x={x}
                y={y + 5}
                textAnchor="middle"
                fontSize="14"
                fontWeight="bold"
            >
                {node.value}
            </text>

            {/* Children */}
            {node.left && (
                <GraphicalTreeNode
                    node={node.left}
                    x={leftX}
                    y={childY}
                    depth={depth + 1}
                    spacing={horizontalSpacing}
                />
            )}
            {node.right && (
                <GraphicalTreeNode
                    node={node.right}
                    x={rightX}
                    y={childY}
                    depth={depth + 1}
                    spacing={horizontalSpacing}
                />
            )}
        </>
    );
}

export default GraphicalTreeNode;
