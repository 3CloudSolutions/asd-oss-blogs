import React from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import NotFound from "./NotFound";
import Home from "../home/Home";
import Houses from "../house/Houses";

function WebRoutes() {
    return (
        <>
            <Router>
                <Routes>
                    <Route key="Home" path="/*" element={<Home />} />
                    <Route path="*" element={<NotFound />} />
                </Routes>
            </Router>
        </>
    );
}


export default WebRoutes;



