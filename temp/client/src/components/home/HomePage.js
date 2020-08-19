import React, { useEffect,useState } from 'react';
import { useDispatch } from 'react-redux';
import { useHistory, Switch, Route, Link } from 'react-router-dom';
import * as styles from './HomePage.module.css';
import { Navbar, Nav, NavDropdown } from 'react-bootstrap';
import * as actions from '../../store/actions/login';
import 'bootstrap/dist/css/bootstrap.min.css';
import NewProduct from '../product/new-product/NewProduct.jsx';
import AllProducts from '../product/all-products/AllProducts';
import UpdateProduct from '../product/update-product/UpdateProduct';
function HomePage(props) {
    const [loggedUser,setLoggedUser] = useState(null);
    const history = useHistory();
    const dispatch = useDispatch();

    var dropdown = null;

    useEffect(() => {
        if(localStorage.getItem(`loggedUser`)) {
            setLoggedUser(JSON.parse(localStorage.getItem(`loggedUser`)));
        }else {
            history.push('/login');
        }

    },[history])
    if (loggedUser) {
        if (loggedUser.type === `ADMIN`) {
            dropdown =
                (<NavDropdown className={`${styles.dropdown}`}title="Actions" id="basic-nav-dropdown">
                    <Link className={`${styles.dropdownItem}`} to={`/product/new`}>New product</ Link>
                    <br />
                    <Link className={`${styles.dropdownItem}`} to={`/product/all`}>All products</ Link>
                </NavDropdown>)
        }
    }


    const logout = () => {
        dispatch(actions.logout());
        history.push(`/login`);
    }

    return (
        <div>
            <Navbar bg="dark" variant="dark">
                <Navbar.Brand to={`/`}>Navbar</Navbar.Brand>
                <Nav className="mr-auto">
                    <Link className="nav-link" to={`/`}>Home</Link>
                    {dropdown}
                </Nav>
                 <Nav className="mr-left">
                    <Nav.Link className="nav-link" onClick={logout}>Logout</Nav.Link>
                </Nav>
            </Navbar>
            <Switch>
                <Route path={`/product/new`}>
                    <NewProduct />
                </Route>
                <Route path={`/product/all`}>
                    <AllProducts />
                </Route>
                <Route path={`/product/update/:id`}>
                    {({match}) => {
                        return <UpdateProduct id={match.params.id}/>
                    }}
                </Route>
            </Switch>
        </div>
    )

}
export default HomePage;
