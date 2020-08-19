import React, {useState,useEffect} from "react";
import axios from 'axios'
import * as styles from "../new-product/NewProduct.module.css";
import {Button, Form} from "react-bootstrap";
import {useHistory} from 'react-router-dom';

function UpdateProduct({id}) {
    const [productId,setProductId] = useState();
    const [productName,setProductName] = useState('');
    const [productPrice,setProductPrice] = useState('');
    const history = useHistory();


    useEffect(() => {
        axios.get(`http://localhost:8080/product/${id}`)
            .then((response) => {
                setProductId(response.data.id);
                setProductName(response.data.name);
                setProductPrice(response.data.price);
            }).catch((error)=> {
                console.log(error);
        })
    },[id])

    const updateProduct = (e) => {
        e.preventDefault();
        axios.put(`http://localhost:8080/product/`,{
            id : productId,
            name : productName,
            price : productPrice
        })
            .then((response) => {
                history.push(`/product/all`);
            })
            .catch(err => {
                console.log(err);
            })
    }

    const handleProductNameChange = (e) => {
        setProductName(e.target.value);
    }
    const handleProductPriceChange = (e) => {
        setProductPrice(e.target.value);
    }

    let updateProductForm = (
        <div className={styles.wrapper}>
            <Form onSubmit={(e) => updateProduct(e)}>
                <h1 className={styles.title}>Update product</h1>
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

    return (
        <div>
            {updateProductForm}
        </div>
    )
}

export default UpdateProduct;