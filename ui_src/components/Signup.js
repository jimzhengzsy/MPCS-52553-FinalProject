import React, { useState } from "react";
import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";
import "./Signup.css";
import Top from "./Top";

export default function Signup() {
  const [email, setEmail] = useState("");
  const [name, setName] = useState("");
  const [password, setPassword] = useState("");
  const [password2, setPassword2] = useState("");
  const [id, setId] = useState("");
  const [ans1, setAns1] = useState("");
  const [ans2, setAns2] = useState("");
  const [ans3, setAns3] = useState("");
  const [role, setRole] = useState("");

  function validateForm() {
    return email.length > 0 && password.length > 0;
  }


  function handleSubmit(event) {
    event.preventDefault();

  }


  return (
      <>
        <Top />
        <div className="Signup">
          <Form onSubmit={handleSubmit}>

            <Form.Group size="lg" controlId="name">
              <Form.Label>Name</Form.Label>
                <Form.Control
                  autoFocus
                  type="name"
                  value={name}
                  onChange={(e) => setName(e.target.value)}
                />
            </Form.Group>

            <Form.Group size="lg" controlId="email">
              <Form.Label>Email</Form.Label>
                <Form.Control
                  autoFocus
                  type="email"
                  value={email}
                  onChange={(e) => setEmail(e.target.value)}
                />
              </Form.Group>

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

            <Form.Group size="lg" controlId="id">
              <Form.Label>ID</Form.Label>
              <Form.Control
                type="id"
                value={id}
                onChange={(e) => setId(e.target.value)}
              />
            </Form.Group>

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


            <div>
              <label>
                <input type="radio"
                       value="teacher"
                       checked={role === "teacher"}
                       onChange= {(e) => setRole(e.target.value)}
                />
                  Teacher
                </label>
            </div>
            <div>
              <label>
                <input type="radio"
                       value="student"
                       checked={role === "student"}
                       onChange= {(e) => setRole(e.target.value)}
                />
                  Student
              </label>
            </div>

            <Button block size="lg" type="submit" disabled={!validateForm()}>
              Sign Up
            </Button>
        </Form>
      </div>
      </>

  );
}