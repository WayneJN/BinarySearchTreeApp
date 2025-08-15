function Toast({ type, message }) {
    const styles = {
        padding: '0.5rem 1rem',
        margin: '1rem 0',
        borderRadius: '5px',
        color: '#fff',
        backgroundColor: type === 'success' ? 'green' : 'red'
    };

    return <div style={styles}>{message}</div>;
}

export default Toast;
