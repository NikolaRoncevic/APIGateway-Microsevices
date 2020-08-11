import React, { useState, useEffect} from 'react';
import { useHistory } from "react-router-dom";
import * as styles from './Login.module.css'
import { Button, Form, Alert } from 'react-bootstrap';
import axios from 'axios';
import 'bootstrap/dist/css/bootstrap.min.css';



function Login(props) {
    const [username,setUsername] =useState(``);
    const [password,setPassword]= useState(``);
    const [error,setError] = useState(false);
    const history = useHistory();

  
   
  
    function handleLogin(event) {
        event.preventDefault();
        const data = {
            username: username,
            password: password
          };
          axios
            .post(`http://localhost:8080/auth/login`, data)
            .then(res => {
                console.log(res);
                setError(false);
                history.push(`/`);
                localStorage.setItem('loggedUser',JSON.stringify(res.data));
            })
            .catch(err => {
                setError(true);
            });
        
    }
    useEffect(() => {
        const loggedUser = localStorage.getItem(`loggedUser`);
        if(loggedUser !== undefined) {
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