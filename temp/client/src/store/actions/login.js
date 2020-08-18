import * as actionTypes from './actionTypes';
import axios from 'axios';

const setLoggedUser = (response) => {
    return {
        type: actionTypes.SET_LOGGED_USER,
        loggedUser: response.data
    }
}

const loginFailed = (error) => {

    //DODATI ERROR MESSAGE
    return {
        type: actionTypes.LOGIN_FAILED

    }
}

export const logout = () => {
    return {
        type: actionTypes.LOGOUT
    }
}

export const login = (data) => {
    return dispatch => {
        axios
            .post(`http://localhost:8080/auth/login`, data)
            .then(res => {
                dispatch(setLoggedUser(res))
            })
            .catch(err => {
                dispatch(loginFailed(err))
            });
    }
}