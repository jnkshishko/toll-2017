package controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import services.WriteToFile;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ReceiveControllerTest {

    @Mock
    WriteToFile writeToFile;

    @InjectMocks
    ReceiveController mockedController;

    @Test
    public void receiveCoords() throws Exception {
        String coordinates = "135,0 130,1";
        when(writeToFile.write(coordinates)).thenReturn(true);

        String result = mockedController.receiveCoords(coordinates);
        assertEquals("{status: ok}", result);

    }

}