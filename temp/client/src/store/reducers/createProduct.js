import * as actionTypes from './../actions/actionTypes'

const intialState = {
    createProductFailed : false,
    createProductSucess : false
}


const createProductFailed = (state, action) => {
    return {
        ...state,
        createProductFailed : true,
        createProductSucess : false,
    }
}
const createProductStarted = (state,action) => {
    return {
        ...state,
        createProductFailed : false,
        createProductSucess : false,
    }
}
const createProductFinished = (state,action) => {
    return {
        ...state,
        createProductFailed : false,
        createProductSucess : true,

    }
}
export const createProductReducer = (state = intialState, action) => {
    switch (action.type) {
        case actionTypes.CREATE_PRODUCT_START: return createProductStarted(state, action);
        case actionTypes.PRODUCT_CREATED: return createProductFinished(state, action);
        case actionTypes.CREATE_PRODUCT_FAILED: return createProductFailed(state,action);
        default: return state;
    }
}
