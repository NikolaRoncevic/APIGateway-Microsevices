import * as actionTypes from './../actions/actionTypes'

const intialState = {
    fetchProductsSuccess : false,
    fetchProductsFailed : false,
    products : [],
}

const fetchProductsStarted = (state,action) => {
    return {
        ...state,
        fetchProductsSuccess : false,
        fetchProductsFailed : false
    }
}

const fetchProductsFailed = (state,action) => {
    return {
        ...state,
        fetchProductsFailed : true,
        fetchProductsSuccess : false,
    }
}

const fetchProductsFinished = (state,action) => {
    return {
        ...state,
        fetchProductsSuccess : true,
        products : [...action.data]
    }
}

export const getAllProductsReducer = (state = intialState, action) => {
    switch (action.type) {
        case actionTypes.GET_ALL_PRODUCTS_START: return fetchProductsStarted(state, action);
        case actionTypes.GET_ALL_PRODUCTS_FINISHED: return fetchProductsFinished(state, action);
        case actionTypes.GET_ALL_PRODUCTS_FAILED: return fetchProductsFailed(state,action);
        default: return state;
    }
}
