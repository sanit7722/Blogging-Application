import { useState } from "react";
import { Button, Card, CardBody, CardHeader, Col, Container, Form, FormGroup, Input, Label, Row } from "reactstrap";
import Base from "../components/Base";
import { ToastContainer, toast } from 'react-toastify';
  import 'react-toastify/dist/ReactToastify.css';
import { loginUser } from "../Services/user-service";
import { doLogin } from "../auth";
import { data } from "autoprefixer";

const Login = () => {

 const[loginDetails, setLoginDetails] =useState({
    username:'',
    password:''
  })

  const handleChange=(event,field)=>{
    let actualValue=event.target.value
    setLoginDetails({
      ...loginDetails,
      [field]:actualValue
    })
  }

  const handleFormSubmit=(event)=>{
    event.preventDefault();
    console.log(loginDetails);
    if(loginDetails.username.trim()==''|| loginDetails.password.trim()==''){
      toast.error("Username and Password is required");
      return;
    }


    loginUser(loginDetails).then((jwtTokenData)=>{
      console.log("login")
      console.log(jwtTokenData.token)

      doLogin(data,()=>{
        console.log("login details saved");
      })

    }).catch(error=>{
      console.log(error)

      if(error.response.status==400 || error.response.status==404){
       
        toast.error(error.response.data.msg);
        
      }
      else{
        toast.error("Something went wrong");

      }

    })
  };
  const resetData=()=>{
       
    setLoginDetails({
      username:'',
      password:''
    })
}

  return (
    <Base>
      <Container>
        <Row  className="mt-4">
          <Col sm={{ size: 6, offset: 3 }}>
            <Card color="dark" inverse>
              <CardHeader>
                <h3>Login</h3>
              </CardHeader>
              <CardBody>
                <Form onSubmit={handleFormSubmit}>
                    <FormGroup>
                        <Label for="Email" >Email</Label>
                        <Input type="email" placeholder="Enter Email" id="email"
                         value={loginDetails.username}
                         onChange={(e)=>handleChange(e,'username')}
                        ></Input>
                    </FormGroup>
                    <FormGroup>
                        <Label for="password" >Password</Label>
                        <Input type="password" placeholder="Enter Password" id="password"
                        value={loginDetails.password}
                        onChange={(e)=>handleChange(e,'password')}
                        ></Input>
                    </FormGroup>
                    <Container className="text-cennter">
                        <Button outline color="light">Log In</Button>
                        <Button onClick={resetData} className="ms-2" color="secondary">Reset</Button>
                    </Container>
                </Form>
              </CardBody>
            </Card>
          </Col>
        </Row>
      </Container>
      <ToastContainer />
    </Base>
  );
};

export default Login;
