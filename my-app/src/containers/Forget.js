import React, { useState } from "react";
import Form from "react-bootstrap/Form";
// import LoaderButton from "../components/LoaderButton";
import { useForm } from "use-form-fields"
import "./Forget.css";
import Top from "./Top";
import Button from "react-bootstrap/Button";
import { useNavigate } from "react-router-dom";

export default function Forget() {

  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [password2, setPassword2] = useState("");
  const [ans1, setAns1] = useState("");
  const [ans2, setAns2] = useState("");
  const [ans3, setAns3] = useState("");

  const [exist, setExist] = useState(false);
  const [verified, setVerified] = useState(false);
  let nav = useNavigate();

  // const [isLoading, setIsLoading] = useState(false);

  function validateForm() {
    return (
      password2.length > 0 &&
      password.length > 0 &&
      password === password2
    );
  }

   function validateQuestions() {
    return (
        ans1.length > 0 &&
        ans2.length > 0 &&
        ans3.length > 0
    );
  }

  function validateEmail() {
    return email.length > 0;
  }

  async function handleSecuritySubmit(event) {
    event.preventDefault();

    setVerified(true);
  }

  async function handleConfirmationSubmit(event) {
    event.preventDefault();

    setExist(true);
  }

  async function handleSubmit(event) {
    event.preventDefault();

    nav("/dashboards")

  }

  function checkEmailForm() {
    return (
      <Form onSubmit={handleConfirmationSubmit}>
          <Form.Group size="lg" controlId="email">
              <Form.Label>Email</Form.Label>
                <Form.Control
                  autoFocus
                  type="email"
                  value={email}
                  onChange={(e) => setEmail(e.target.value)}
                />
          </Form.Group>

          <Button block size="lg" type="submit" disabled={!validateEmail()}>
              Submit
          </Button>

      </Form>
    );
  }

  function resetForm(){
      return (
          <Form onSubmit={handleSubmit}>

            <Form.Group size="lg" controlId="password">
              <Form.Label>Password</Form.Label>
              <Form.Control
                type="password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
              />
            </Form.Group>

            <Form.Group size="lg" controlId="password2">
              <Form.Label>Confirm Password</Form.Label>
              <Form.Control
                type="password"
                value={password2}
                onChange={(e) => setPassword2(e.target.value)}
              />
            </Form.Group>
          <Button block size="lg" type="submit" disabled={!validateForm()}>
            Submit
        </Button>
      </Form>
      );
  }

  function securityForm() {
    return (
      <Form onSubmit={handleSecuritySubmit}>
          <Form.Label>Security Question: what's your favourite movie?</Form.Label>
            <Form.Group size="lg" controlId="ans1">
              <Form.Control
                type="ans1"
                value={ans1}
                onChange={(e) => setAns1(e.target.value)}
              />
            </Form.Group>

            <Form.Label>Security Question: what's your favourite city?</Form.Label>
            <Form.Group size="lg" controlId="ans2">
              <Form.Control
                type="asn2"
                value={ans2}
                onChange={(e) => setAns2(e.target.value)}
              />
            </Form.Group>

            <Form.Label>Security Question: what's your favourite country?</Form.Label>
            <Form.Group size="lg" controlId="ans3">
              <Form.Control
                type="ans3"
                value={ans3}
                onChange={(e) => setAns3(e.target.value)}
              />
            </Form.Group>
          <Button block size="lg" type="submit" disabled={!validateQuestions()}>
            Submit
        </Button>
      </Form>


    );
  }

  if (!exist)
      return (
          <>
              <Top />
              <div className="Forget">
                  {checkEmailForm()}
              </div>
          </>
              );
  else{
      if (!verified)
      {
          return(
              <>
                  <Top />
                  <div className="Forget">
                      {securityForm()}
                  </div>
              </>
          );
      }
      else{

          return(
              <>
                  <Top />
                  <div className="Forget">
                      {resetForm()}
                  </div>
              </>
          );

      }

  }
}



