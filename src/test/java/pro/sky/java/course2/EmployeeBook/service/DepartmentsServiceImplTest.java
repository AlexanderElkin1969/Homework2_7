package pro.sky.java.course2.EmployeeBook.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DepartmentsServiceImplTest {

    @Mock
    private EmployeeBookService employeeBookServiceMock;

    @InjectMocks
    private DepartmentsServiceImpl out;




}
