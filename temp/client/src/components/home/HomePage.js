import React, { useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { useHistory } from 'react-router-dom';
//import * as styles from './HomePage.module.css'
import { Navbar, Nav } from 'react-bootstrap';
import * as actions from '../../store/actions/login'
import 'bootstrap/dist/css/bootstrap.min.css';

function HomePage(props) {
    const loggedUser = useSelector(state => state.login.loggedUser);
    const history = useHistory();
    const dispatch = useDispatch();
    useEffect(() => {
        if (loggedUser.id === null) {
            history.push(`/login`);
        }
    },[loggedUser,history])

    const logout = () => {
        dispatch(actions.logout());
        history.push(`/login`)
        

    }


    return (
        <Navbar bg="dark" variant="dark">
            <Navbar.Brand href="#home">Navbar</Navbar.Brand>
            <Nav className="mr-auto">
                <Nav.Link href="#home">Home</Nav.Link>
                <Nav.Link href="#features">Features</Nav.Link>
                <Nav.Link href="#pricing">Pricing</Nav.Link>
            </Nav>
            <Nav className="mr-left">
            <Nav.Link onClick={logout}>Logout</Nav.Link>
                
                

            </Nav>
        </Navbar>
    )

}


export default HomePage;
