package com.nnk.springboot.unitTest;


import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.repositories.CurvePointRepository;
import com.nnk.springboot.services.CurvePointService;
import com.nnk.springboot.services.impl.CurvePointServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CurvePointServiceTest {

    private List<CurvePoint> Curves;
    @Mock
    private CurvePointRepository repository;


    private CurvePointService service;


    private static List<CurvePoint> createCurves(){

        CurvePoint curve1 = new CurvePoint(1, 1.0, 1.0);

        CurvePoint curve2 = new CurvePoint(2, 1.0, 1.0);

        CurvePoint curve3 = new CurvePoint(3, 1.0, 1.0);

        CurvePoint curve4 = new CurvePoint(4, 1.0, 1.0);


        List<CurvePoint> curvePoints = Arrays.asList(curve1, curve2, curve3, curve4);
        return  curvePoints;

    }

    @BeforeEach
    private void setUpTests(){
        Curves = createCurves();
        service = new CurvePointServiceImpl(repository);
    }

    @Test
    public void getAllCurvesTest(){
        when(repository.findAll()).thenReturn(Curves);

        List<CurvePoint> list = createCurves();

        List<CurvePoint> allCurves = service.getAllCurvePoints();

        assertIterableEquals(list, allCurves);

    }

    @Test
    public void getCurveByidTest() throws Exception {

        when(repository.findById(any(Integer.class))).thenReturn(Optional.ofNullable(Curves.get(0)));

        List<CurvePoint> list = createCurves();

        CurvePoint CurvePointById = service.getCurvePointById(1);

        assertEquals(list.get(0), CurvePointById);

    }


    @Test
    public void saveCurveTest(){

        CurvePoint curvePoint = new CurvePoint(5, 1.0, 1.0);

        when(repository.save(any(CurvePoint.class))).thenReturn(curvePoint);

        CurvePoint curvePoint1 = service.saveCurvePoint(curvePoint);

        assertEquals(curvePoint, curvePoint1);

    }

}
