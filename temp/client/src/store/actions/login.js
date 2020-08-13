import * as actionTypes from './actionTypes';
import axios from 'axios';

export const setLoggedUser = (response) => {
    return {
        type: actionTypes.SET_LOGGED_USER,
        loggedUser: response.data
    }
}

export const loginFailed = (error) => {

    //DODATI ERROR MESSAGE
    return {
        type: actionTypes.LOGIN_FAILED

    }
}

export const login = (data) => {
    return dispacth => {
        axios
            .post(`http://localhost:8080/auth/login`, data)
            .then(res => {
                dispacth(setLoggedUser(res))

            })
            .catch(err => {
                dispacth(loginFailed(err))
            });
    }
}