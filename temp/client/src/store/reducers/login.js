import * as actionTypes from './../actions/actionTypes'

const intialState = {
    loggedUser: {
        id : null,
        username : null,
        type : null,
    },
    loginError: false,
}

const setLoggedUser = (state, action) => {
    return {
        ...state,
        loginError: false,
        loggedUser: {
            ...state.loggedUser,
            id: action.loggedUser.id,
            username: action.loggedUser.username,
            type: action.loggedUser.type
        }
    }
}
const loginFailed = (state, action) => {
    return {
        ...state,
        loginError: true,
    }
}

const logout = (state,action) => {
    return {
        ...state,
        loggedUser: {
            ...state.loggedUser,
            id : null,
            username : null,
            type: null
        }
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
