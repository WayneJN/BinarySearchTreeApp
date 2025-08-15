import axios from 'axios';

const BASE_URL = 'http://localhost:8080/api/bst';

export const processNumbers = async (numbers, balanced = false) => {
    const endpoint = balanced ? '/process-balanced' : '/process-numbers';
    return axios.post(`${BASE_URL}${endpoint}`, numbers);
};

export const getPreviousTrees = async () => {
    return axios.get(`${BASE_URL}/previous-trees`);
};
