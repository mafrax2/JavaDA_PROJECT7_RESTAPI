package com.nnk.springboot.services.impl;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.repositories.CurvePointRepository;
import com.nnk.springboot.services.CurvePointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurvePointServiceImpl implements CurvePointService {

        @Autowired
        private CurvePointRepository repository;

    public CurvePointServiceImpl(CurvePointRepository repository) {
        this.repository = repository;
    }

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
