package com.nnk.springboot.services;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.repositories.CurvePointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurvePointService {

        @Autowired
        private CurvePointRepository repository;

        public List<CurvePoint> getAllCurvePoints(){
            return repository.findAll();
        }

        public CurvePoint getCurvePointById(int id) throws Exception {
            return repository.findById(id).orElseThrow(() -> new Exception("CurvePoint not found"));
        }

        public void deleteCurvePointById(int id){
            repository.deleteById(id);
        }

        public CurvePoint saveCurvePoint(CurvePoint curvePoint){
            return repository.save(curvePoint);
        }
}
