import React, { useState } from 'react';
import { Button, Form, Alert } from 'react-bootstrap';
import { useDispatch, useSelector } from 'react-redux';
import * as actions from '../../../store/actions/createProduct'
import * as styles from './NewProduct.module.css'
import { useEffect } from 'react';
function NewProduct(props) {

    const [productName, setProductName] = useState('');
    const [productPrice, setProductPrice] = useState('');
    const error = useSelector(state => state.createProduct.createProductFailed);
    const success = useSelector(state => state.createProduct.createProductSucess);

    const dispatch = useDispatch();

    function handleProductNameChange(e) {
        setProductName(e.target.value);
    }
    function handleProductPriceChange(e) {
        setProductPrice(e.target.value);
    }
    function createNewProduct(e) {
        e.preventDefault();
        let data = {
            name: productName,
            price: productPrice
        }
        dispatch(actions.createProduct(data));



    }
    useEffect(() => {
        console.log(error + " " + success);
    })
    let data = (
        <div className={styles.wrapper}>
            <Form onSubmit={(e) => createNewProduct(e)}>
                <h1 className={styles.title}>Add new product</h1>
                <hr />
                <Form.Group controlId="formName">
                    <Form.Label>Name</Form.Label>
                    <Form.Control type="text" placeholder="Name" value={productName} onChange={handleProductNameChange} />
                </Form.Group>
                <Form.Group controlId="formPrice">
                    <Form.Label>Price</Form.Label>
                    <Form.Control type="number" placeholder="Price" value={productPrice} onChange={handleProductPriceChange} />
                </Form.Group>
                <Button variant="primary" type="submit">Submit</Button>
            </Form>
        </div>
    )
    if (error === true) {
        data = (
            <div>
                {data}
                <Alert className={styles.alert} variant={`danger`}>Doslo je do greske prilikom kreiranja proizvoda moguce je da postoji proizvod sa istim imenom</Alert>
            </div>
        )
    }
    if (success === true) {
        data = (
            <div>
                {data}
                <Alert className={styles.alert} variant={`success`}>Uspesno ste kreirali proizvod</Alert>
            </div>
        )
    }
    return data;
}

export default NewProduct;
