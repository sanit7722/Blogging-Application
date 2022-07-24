import { Button, Card, CardBody, CardHeader, Col, Container, Form, FormGroup, Input, Label, Row } from "reactstrap";
import Base from "../components/Base";

const Login = () => {
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
                <Form>
                    <FormGroup>
                        <Label for="Email" >Email</Label>
                        <Input type="email" placeholder="Enter Email" id="email"></Input>
                    </FormGroup>
                    <FormGroup>
                        <Label for="password" >Password</Label>
                        <Input type="password" placeholder="Enter Password" id="password"></Input>
                    </FormGroup>
                    <Container className="text-cennter">
                        <Button outline color="light">Log In</Button>
                        <Button className="ms-2" color="secondary">Reset</Button>
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

export default Login;
