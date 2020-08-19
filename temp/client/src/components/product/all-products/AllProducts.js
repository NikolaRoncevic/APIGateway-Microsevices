import React, { useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import * as actions from '../../../store/actions/getAllProducts';
import * as styles from './AllProducts.module.css'
import { Alert,Button } from 'react-bootstrap';
import {Link} from "react-router-dom";
function AllProducts(props) {
    const products = useSelector(state => state.fetchProducts.products);
    const sucess = useSelector(state => state.fetchProducts.fetchProductsSuccess);
    const error = useSelector(state => state.fetchProducts.fetchProductsFailed);
    const dispatch = useDispatch();
    let data = null;
    useEffect(() => {
        dispatch(actions.getProducts());
    }, [dispatch])
    if (sucess) {
        data = products.map((product, index) => (
            <tr key={product.id}>
                <td>{index}</td>
                <td>{product.name}</td>
                <td>{product.price}</td>
                <td><Link className={styles.link} to={`/product/update/${product.id}`}><Button>Update product</Button></Link></td>
            </tr>
        ))
    }
    let table = (
        <table className="table">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Name</th>
                    <th scope="col">Price</th>
                    <th scope="col"></th>
                </tr>
            </thead>
            <tbody>
                {data}
            </tbody>
        </table>)
    if (error) {
        table = (
            <div>
                {table}
                <Alert variant={`danger`}>Doslo je do greske prilikom ucitavanja proizvoda</Alert>
            </div>
        )
    }
    return (
        table
    )

}

export default AllProducts;