package pro.sky.java.course2.EmployeeBook.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.EmployeeBook.constant.EmployeeConstants;
import pro.sky.java.course2.EmployeeBook.model.Employee;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import static pro.sky.java.course2.EmployeeBook.constant.EmployeeConstants.EMPLOYEE_LIST;

@ExtendWith(MockitoExtension.class)
public class DepartmentsServiceImplTest {

    @Mock
    private EmployeeBookService employeeBookServiceMock;

    @InjectMocks
    private DepartmentsServiceImpl out;

    @Test
    public void shouldReturnCollectionAllEmployees() {
        when(out.allOfDepartment(1)).thenReturn((ArrayList<Employee>) EMPLOYEE_LIST);

    }




}
