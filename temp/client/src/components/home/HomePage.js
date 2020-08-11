import React from 'react';
//import * as styles from './HomePage.module.css'
import { Navbar, Nav} from 'react-bootstrap';
//import axios from 'axios';
import 'bootstrap/dist/css/bootstrap.min.css';

function HomePage(props) {

    return (
        <Navbar bg="dark" variant="dark">
            <Navbar.Brand href="#home">Navbar</Navbar.Brand>
            <Nav className="mr-auto">
                <Nav.Link href="#home">Home</Nav.Link>
                <Nav.Link href="#features">Features</Nav.Link>
                <Nav.Link href="#pricing">Pricing</Nav.Link>
            </Nav>
        </Navbar>
    )

}


export default HomePage;
