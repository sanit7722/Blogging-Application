import { useEffect, useState } from "react";
import { Button, Card, CardBody, CardHeader, Col, Container, Form, FormGroup, Input, Label, Row } from "reactstrap";
import Base from "../components/Base";

const Signup = () => {

    const[data, setData]=useState({
        name:'',
        email:'',
        password:'',
        about:''

    })
    const[error, setError]=useState({

        errors:{},
        isError:false 
    })


    const handleChange=(event, property)=>{
        setData({...data,[property]:event.target.value})
    }

    const resetData=()=>{
        setData({
            name:'',
            email:'',
            password:'',
            about:''
        })
    }

    const submitForm=(event)=>{

        event.preventDefault()
    }

  return (
    <Base>
      <Container>
        <Row className="mt-4">
            <Col sm={{size:6,offset:3}}>
            <Card color="dark" inverse>
          <CardHeader>
            <h3>Register Now</h3>
          </CardHeader>
          <CardBody>
            <Form onSubmit={submitForm}>
                <FormGroup>
                    <Label for="name">Name</Label>
                    <Input type="text" placeholder="Enter Name" id="name" 
                    onChange={(e)=>handleChange(e,'name')}
                    value={data.name}
                    />
                </FormGroup>
                <FormGroup>
                    <Label for="email">Email</Label>
                    <Input type="email" placeholder="Enter Email" id="email"
                     onChange={(e)=>handleChange(e,'email')}
                     value={data.email}
                    />
                </FormGroup>
                <FormGroup>
                    <Label for="password">Password</Label>
                    <Input type="password" placeholder="Enter Password" id="password"
                     onChange={(e)=>handleChange(e,'password')}
                     value={data.password}
                    />
                </FormGroup>
                <FormGroup>
                    <Label for="about">About</Label>
                    <Input type="textarea" placeholder="Enter About" id="About"
                     onChange={(e)=>handleChange(e,'about')}
                     value={data.about}
                    />
                </FormGroup>
                <Container className="text-center">
                    <Button outline color="light">Sign Up</Button>
                    <Button onClick={resetData} color="secondary" className="ms-2" type="reset">Reset</Button>
                </Container>
            </Form>
          </CardBody>
        </Card>
            </Col>
        </Row>
      </Container>
    </Base>
  );
};

export default Signup;
