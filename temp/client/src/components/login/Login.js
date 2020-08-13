import React, { useState, useEffect} from 'react';
import { useHistory } from "react-router-dom";
import * as styles from './Login.module.css'
import { Button, Form, Alert } from 'react-bootstrap';
import axios from 'axios';
import { useSelector,useDispatch } from 'react-redux';
import * as actions from '../../store/actions/login';
import 'bootstrap/dist/css/bootstrap.min.css';



function Login(props) {
    const [username,setUsername] =useState(``);
    const [password,setPassword]= useState(``);
    const loggedUser = useSelector(state => state.login.loggedUser);
    const error = useSelector(state => state.login.loginError);
    const history = useHistory();
    const dispatch = useDispatch();

  
   
  
    function handleLogin(event) {
        event.preventDefault();
        console.log('doso');
        const data = {
            username: username,
            password: password
          };
          dispatch(actions.login(data));
        
    }
    useEffect(() => {
        if(loggedUser.id !== null){
            history.push(`/`);
        }
        

      });
    function handleUsernameChange(e) {
        setUsername(e.target.value);
    }
    function handlePasswordChange(e) {
        setPassword(e.target.value);
    }
    let data = (
        <div className={styles.wrapper}>
            <Form onSubmit={(event) => handleLogin(event)}>
                <Form.Group controlId="formBasicEmail">
                    <Form.Label>Username</Form.Label>
                    <Form.Control type="text" placeholder="Username" value={username} onChange={handleUsernameChange} />
                </Form.Group>
                <Form.Group controlId="formBasicPassword">
                    <Form.Label>Password</Form.Label>
                    <Form.Control type="password" placeholder="Password" value={password} onChange={handlePasswordChange}/>
                </Form.Group>
                <Button variant="primary" type="submit">Submit</Button>
            </Form>
        </div>
    );
    if(error === true) {
        data = (
            <div>
                {data}
                <Alert className={styles.error}variant={`danger`}>Uneli ste pogresan username ili password</Alert>
            </div>
        )
        
    }
    return data;
}

export default Login;