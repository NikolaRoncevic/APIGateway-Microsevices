import * as actionTypes from './actionTypes';
import axios from 'axios';
const productCreated = (response) => {
    return {
        type: actionTypes.PRODUCT_CREATED
    }
}

const createProductFailed = (response) => {
    console.log(response);
    return {
        type : actionTypes.CREATE_PRODUCT_FAILED
    }
}

const createProductStarted = () => {
    return {
        type : actionTypes.CREATE_PRODUCT_START
    }
}

export const createProduct = (data) => {
    return dispatch => {
        dispatch(createProductStarted())
        axios
            .post(`http://localhost:8080/product/new`, data)
            .then(res => {
                dispatch(productCreated(res))
            })
            .catch(err => {
                dispatch(createProductFailed(err))
            });
    }
}
