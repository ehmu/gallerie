import axios from 'axios';

const baseDonmain = 'http://192.168.178.21:8080/api';

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
