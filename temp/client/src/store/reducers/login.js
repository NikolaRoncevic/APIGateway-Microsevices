import * as actionTypes from './../actions/actionTypes'


const intialState = {
    loginError: false,
    loginComplete : false,
}

const setLoggedUser = (state, action) => {
    localStorage.setItem('loggedUser',JSON.stringify(action.loggedUser));
    return {
        ...state,
        loginError: false,
        loginComplete : true
    }
}
const loginFailed = (state, action) => {
    return {
        ...state,
        loginError: true,
        loginComplete : false
    }
}

const logout = (state,action) => {
    localStorage.removeItem('loggedUser');
    return {
        ...state,
    }
}

export const loginReducer = (state = intialState, action) => {
    switch (action.type) {
        case actionTypes.SET_LOGGED_USER: return setLoggedUser(state, action);
        case actionTypes.LOGIN_FAILED: return loginFailed(state, action);
        case actionTypes.LOGOUT: return logout(state,action);
        default: return state;
    }
}
