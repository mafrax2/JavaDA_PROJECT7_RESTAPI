package com.nnk.springboot.services;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.repositories.CurvePointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CurvePointService {



         List<CurvePoint> getAllCurvePoints();

         CurvePoint getCurvePointById(int id) throws Exception;

         void deleteCurvePointById(int id);

         CurvePoint saveCurvePoint(CurvePoint curvePoint);
}
