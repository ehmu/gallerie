import axios from 'axios';

const baseDonmain = 'http://localhost:8000';

export const customHeader = {
    'Content-Type': 'application/json',
    Accept: 'application/json'
};

export const baseUrl = `${ baseDonmain }`;
export const currentDemo = 3;

export default axios.create( {
    baseUrl,
    headers: customHeader
} )