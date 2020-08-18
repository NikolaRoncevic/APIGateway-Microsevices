import * as actionTypes from './actionTypes';
import axios from 'axios';

const productsFetched = (response) => {
    return {
        type: actionTypes.GET_ALL_PRODUCTS_FINISHED,
        data: response.data
        
    }
}

const getProductsFailed = (response) => {
    return {
        type : actionTypes.GET_ALL_PRODUCTS_FAILED
    }
}

const getProductsStarted = () => {
    return {
        type : actionTypes.GET_ALL_PRODUCTS_START
    }
}

export const getProducts = () => {
    return dispatch => {
        dispatch(getProductsStarted())
        axios
            .get(`http://localhost:8080/product/all`)
            .then(res => {
                console.log('dovukao proizvode');
                dispatch(productsFetched(res))
            })
            .catch(err => {
                console.log('greska ozbiljna');
                dispatch(getProductsFailed(err))
            });
    }
}
