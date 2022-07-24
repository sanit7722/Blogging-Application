import { Button, Card, CardBody, CardHeader, Col, Container, Form, FormGroup, Input, Label, Row } from "reactstrap";
import Base from "../components/Base";

const Signup = () => {
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
            <Form>
                <FormGroup>
                    <Label for="name">Name</Label>
                    <Input type="text" placeholder="Enter Name" id="name"></Input>
                </FormGroup>
                <FormGroup>
                    <Label for="email">Email</Label>
                    <Input type="email" placeholder="Enter Email" id="email"></Input>
                </FormGroup>
                <FormGroup>
                    <Label for="password">Password</Label>
                    <Input type="password" placeholder="Enter Password" id="password"></Input>
                </FormGroup>
                <FormGroup>
                    <Label for="about">About</Label>
                    <Input type="textarea" placeholder="Enter About" id="About"></Input>
                </FormGroup>
                <Container className="text-center">
                    <Button outline color="light">Sign Up</Button>
                    <Button color="secondary" className="ms-2" type="reset">Reset</Button>
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
