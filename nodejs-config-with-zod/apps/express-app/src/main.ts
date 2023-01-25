import express from "express";
import { AppConfig } from "./config";

const app = express()
const port = 3000

app.get('/', (req, res) => {
  res.send(JSON.stringify(AppConfig));
})

app.listen(port, () => {
  console.log(`Example app listening on port ${port}`)
})