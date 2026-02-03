"""
Test Endpoint 3: GET /api/companies/{id}/high-salary-employees
Validacion del endpoint de empleados con salario alto
Puntaje total: 2.0 puntos
"""

import requests
from typing import Dict, Any, List

BASE_URL = "http://localhost:8080"
ENDPOINT = f"{BASE_URL}/api/companies"


class TestEndpoint3HighSalary:
    """Tests para el Endpoint 3: Obtener empleados con salario alto"""

    TOTAL_POINTS = 2.0
    test_results: List[bool] = []

    @classmethod
    def calculate_score(cls) -> float:
        passed = sum(1 for result in cls.test_results if result)
        total = len(cls.test_results)
        if total == 0:
            return 0.0
        return round((passed / total) * cls.TOTAL_POINTS, 2)

    def validate_structure(self, data: Dict[str, Any]) -> tuple[bool, str]:
        errors = []
        required_fields = ["count", "employees"]
        for field in required_fields:
            if field not in data:
                errors.append(f"Campo requerido '{field}' no encontrado")

        if "count" in data and not isinstance(data["count"], int):
            errors.append("Campo 'count' debe ser int")

        if "employees" in data:
            employees = data["employees"]
            if not isinstance(employees, list):
                errors.append(f"Campo 'employees' debe ser array, recibido: {type(employees).__name__}")
            else:
                for idx, emp in enumerate(employees):
                    if not isinstance(emp, dict):
                        errors.append(f"Empleado[{idx}] debe ser objeto")
                        continue
                    for field in ["id", "firstName", "lastName", "email", "salary"]:
                        if field not in emp:
                            errors.append(f"Empleado[{idx}].{field} no encontrado")
                    if "id" in emp and not isinstance(emp["id"], int):
                        errors.append(f"Empleado[{idx}].id debe ser int")
                    if "salary" in emp and not isinstance(emp["salary"], (int, float)):
                        errors.append(f"Empleado[{idx}].salary debe ser number")

        return len(errors) == 0, "; ".join(errors) if errors else "Estructura valida"

    def test_01_default_min_salary(self):
        company_id = 1
        response = requests.get(f"{ENDPOINT}/{company_id}/high-salary-employees")
        try:
            assert response.status_code == 200, f"Expected 200, got {response.status_code}"
            data = response.json()
            is_valid, message = self.validate_structure(data)
            assert is_valid, f"Estructura DTO invalida: {message}"

            expected_salaries = [7500.0, 7200.0, 6800.0, 6500.0, 6200.0,
                                 6000.0, 5800.0, 5500.0, 5300.0, 5200.0, 5000.0]
            salaries = [emp["salary"] for emp in data["employees"]]
            assert data["count"] == len(expected_salaries), "Count no coincide con esperado"
            assert salaries == expected_salaries, f"Salarios esperados {expected_salaries}, obtenidos {salaries}"

            print("Test 1 PASSED: Default minSalary retorna empleados correctos")
            self.test_results.append(True)
        except AssertionError as exc:
            print(f"Test 1 FAILED: {exc}")
            self.test_results.append(False)
            raise

    def test_02_custom_min_salary(self):
        company_id = 2
        response = requests.get(f"{ENDPOINT}/{company_id}/high-salary-employees?minSalary=7000")
        try:
            assert response.status_code == 200, f"Expected 200, got {response.status_code}"
            data = response.json()
            is_valid, message = self.validate_structure(data)
            assert is_valid, f"Estructura DTO invalida: {message}"

            assert data["count"] == 1, f"Expected count=1, got {data['count']}"
            assert len(data["employees"]) == 1, "Expected 1 employee in list"
            assert data["employees"][0]["salary"] == 7000.0, "Expected salary 7000.0"

            print("Test 2 PASSED: minSalary personalizado filtra correctamente")
            self.test_results.append(True)
        except AssertionError as exc:
            print(f"Test 2 FAILED: {exc}")
            self.test_results.append(False)
            raise

    def test_03_company_inactive(self):
        company_id = 3
        response = requests.get(f"{ENDPOINT}/{company_id}/high-salary-employees")
        try:
            assert response.status_code == 404, f"Expected 404, got {response.status_code}"
            data = response.json()
            assert "message" in data, "Response debe contener campo 'message'"
            print("Test 3 PASSED: Empresa inactiva retorna 404")
            self.test_results.append(True)
        except AssertionError as exc:
            print(f"Test 3 FAILED: {exc}")
            self.test_results.append(False)
            raise

    def test_04_no_results(self):
        company_id = 1
        response = requests.get(f"{ENDPOINT}/{company_id}/high-salary-employees?minSalary=9000")
        try:
            assert response.status_code == 200, f"Expected 200, got {response.status_code}"
            data = response.json()
            is_valid, message = self.validate_structure(data)
            assert is_valid, f"Estructura DTO invalida: {message}"
            assert data["count"] == 0, f"Expected count=0, got {data['count']}"
            assert data["employees"] == [], "Employees debe ser lista vacia"
            print("Test 4 PASSED: Sin resultados retorna lista vacia")
            self.test_results.append(True)
        except AssertionError as exc:
            print(f"Test 4 FAILED: {exc}")
            self.test_results.append(False)
            raise


def run_all_tests(show_output: bool = True):
    if show_output:
        print("=" * 80)
        print("EJECUTANDO TESTS - ENDPOINT 3: GET /api/companies/{id}/high-salary-employees")
        print("=" * 80)
        print()

    test_class = TestEndpoint3HighSalary()

    tests = [
        test_class.test_01_default_min_salary,
        test_class.test_02_custom_min_salary,
        test_class.test_03_company_inactive,
        test_class.test_04_no_results,
    ]

    for idx, test in enumerate(tests, 1):
        if show_output:
            print(f"\n--- Test {idx}/{len(tests)}: {test.__name__} ---")
        try:
            test()
        except Exception as exc:
            if show_output:
                print(f"ERROR: {exc}")

    passed = sum(1 for result in test_class.test_results if result)
    total = len(test_class.test_results)
    score = test_class.calculate_score()

    if show_output:
        print("\n" + "=" * 80)
        print("RESUMEN DE RESULTADOS")
        print("=" * 80)
        print(f"Tests ejecutados: {total}")
        print(f"Tests aprobados: {passed}")
        print(f"Tests fallidos: {total - passed}")
        print(f"\nPUNTAJE FINAL: {score} / {test_class.TOTAL_POINTS} puntos")
        print("=" * 80)

    return score, test_class.TOTAL_POINTS, passed, total


if __name__ == "__main__":
    try:
        score, total_points, passed, total = run_all_tests(show_output=True)
        exit(0 if score == TestEndpoint3HighSalary.TOTAL_POINTS else 1)
    except Exception as exc:
        print(f"\nERROR CRITICO: {exc}")
        exit(1)
