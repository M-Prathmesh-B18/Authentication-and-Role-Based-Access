import { Route, Routes } from "react-router-dom";
import App from "../App";
import Signup from "../signup";

const MyRoutes = () => {
  return (
    <Routes>
      <Route path="/" element={<App />} />
      <Route path="/signin" element={<h1>Signin Page</h1>} />
      <Route path="/signup" element={<Signup />} />
    </Routes>
  );
};
export default MyRoutes;
