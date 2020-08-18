import React, { useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import * as actions from '../../../store/actions/getAllProducts';
import { Alert } from 'react-bootstrap';
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
            <tr>
                <td>{index}</td>
                <td>{product.name}</td>
                <td>{product.price}</td>
            </tr>
        ))
    }
    let table = (
        <table class="table">
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