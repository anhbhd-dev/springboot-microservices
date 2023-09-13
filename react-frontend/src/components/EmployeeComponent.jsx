import React, { useEffect, useState } from "react";
import SpinnerLoading from "./SpinnerLoading";

const EmployeeComponent = () => {
  const [info, setInfo] = useState({});
  const EMPLOYEE_SERVICE_BASE_URL = "http://localhost:9191/api/employees";
  const employeeId = 1;
  const [isLoading, setIsLoading] = useState(true);
  const [httpError, setHttpError] = useState(null);

  useEffect(() => {
    const fetchEmployeeData = async () => {
      const url = `${EMPLOYEE_SERVICE_BASE_URL}/${employeeId}`;

      try {
        const response = await fetch(url);

        if (!response.ok) {
          throw new Error("Something went wrong!");
        }

        const responseJson = await response.json();
        setInfo(responseJson);
        console.log(responseJson)
        setIsLoading(false);
      } catch (error) {
        setIsLoading(false);
        setHttpError(error.message);
      }
    };

    fetchEmployeeData();
  }, [employeeId]);

  if (isLoading) {
    return <SpinnerLoading />;
  }

  if (httpError) {
    return (
      <div className="container m-5">
        <p>{httpError}</p>
      </div>
    );
  }

  return (
    <div className="d-flex align-items-center gap-3 justify-content-center flex-column mt-5">
      <div className="card" style={{ width: "18rem" }}>
        <div className="card-header fw-bold">Employee Info</div>
        <ul className="list-group list-group-flush">
          <li className="list-group-item">First name: {info.employee.firstName}</li>
          <li className="list-group-item">Last name: {info.employee.lastName ? info.employee.lastName : "null"}</li>
          <li className="list-group-item">Email: {info.employee.email}</li>
        </ul>
      </div>
      <div className="card" style={{ width: "18rem" }}>
        <div className="card-header fw-bold">Department Info</div>
        <ul className="list-group list-group-flush">
          <li className="list-group-item">Department name: {info.department.departmentName}</li>
          <li className="list-group-item">Department description: {info.department.departmentDescription}</li>
          <li className="list-group-item">Department code: {info.department.departmentCode}</li>
        </ul>
      </div>
      <div className="card" style={{ width: "18rem" }}>
        <div className="card-header fw-bold">Organization Info</div>
        <ul className="list-group list-group-flush">
          <li className="list-group-item">Organization name: {info.organization.organizationName}</li>
          <li className="list-group-item">Organization description: {info.organization.organizationDescription}</li>
          <li className="list-group-item">Organization code: {info.organization.organizationCode}</li>
        </ul>
      </div>
    </div>
  );
};

export default EmployeeComponent;
