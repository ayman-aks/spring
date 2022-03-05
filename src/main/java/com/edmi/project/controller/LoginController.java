package com.edmi.project.controller;

import com.edmi.project.myclass.*;
import com.edmi.project.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {
    @Autowired
    CandidateConnexionRepository candidateConnexionRepository;
    @RequestMapping("loginCandidate")
    public ModelAndView loginCandidate(HttpServletRequest request)
    {
        HttpSession session=request.getSession();
        session.removeAttribute("verifiyEmailCandidate");
        ModelAndView mv=new ModelAndView("loginCandidate.jsp");
        return mv;
    }
    @RequestMapping("loginCandidateForm")
    public ModelAndView formLoginCandidate(CandidateConnexion candidateConnexion,HttpServletRequest request)
    {
        ModelAndView mv=new ModelAndView();
        List<CandidateIdentifier> candidateIdentifier =candidateConnexionRepository.checkConnexion(candidateConnexion.getEmail(),candidateConnexion.getPassword());
        if(candidateIdentifier.size()==0)
        {
            mv.addObject("errorStatus","Error");
            mv.setViewName("loginCandidate.jsp");
        }
        else
        {
            mv.addObject("errorStatus","connexion");
            mv.setViewName("homeCandidate.jsp");
            HttpSession session=request.getSession();
            //System.out.println("Connexion");
            session.setAttribute("candidateIdentifier",candidateIdentifier);
        }
        return mv;
    }
    @Autowired
    ManagerThesisConnexionRepository managerThesisConnexionRepository;
    @RequestMapping("loginManagerThesis")
    public ModelAndView loginManagerThesis()
    {
        ModelAndView mv=new ModelAndView("loginManagerThesis.jsp");
        return mv;
    }
    @RequestMapping("loginManagerThesisForm")
    public ModelAndView formLoginManagerThesis(ManagerThesisConnexion managerThesisConnexion)
    {
        ModelAndView mv=new ModelAndView();
        List<ManagerThesis> managerThesis = managerThesisConnexionRepository.checkConnexion(managerThesisConnexion.getEmail(),managerThesisConnexion.getPassword());
        if(managerThesis.size()==0)
        {
            mv.addObject("errorStatus","Error");
            mv.setViewName("loginManagerThesis.jsp");
        }
        else
        {
            mv.addObject("errorStatus","emailValid");
            mv.setViewName("homeManagerThesis.jsp");
        }
        return mv;
    }

    @Autowired
    ManagerLaboratoryConnexionRepository managerLaboratoryConnexionRepository;
    @RequestMapping("loginManagerLaboratory")
    public ModelAndView loginManagerLaboratory()
    {
        ModelAndView mv=new ModelAndView("loginManagerLaboratory.jsp");
        return mv;
    }
    @RequestMapping("loginManagerLaboratoryForm")
    public ModelAndView formLoginManagerLaboratory(ManagerLaboratoryConnexion managerLaboratoryConnexion)
    {
        ModelAndView mv=new ModelAndView();
        List<ManagerLaboratory> managerLaboratory = managerLaboratoryConnexionRepository.checkConnexion(managerLaboratoryConnexion.getEmail(),managerLaboratoryConnexion.getPassword());
        if(managerLaboratory.size()==0)
        {
            mv.addObject("errorStatus","Error");
            mv.setViewName("loginManagerLaboratory.jsp");
        }
        else
        {
            mv.addObject("errorStatus","emailValid");
            mv.setViewName("homeManagerLaboratory.jsp");
        }
        return mv;
    }
    @Autowired
    ManagerPhdConnexionRepository managerPhdConnexionRepository;
    @RequestMapping("loginManagerPhd")
    public ModelAndView loginManagerPhd()
    {
        ModelAndView mv=new ModelAndView("loginManagerPhd.jsp");
        return mv;
    }
    @RequestMapping("loginManagerPhdForm")
    public ModelAndView formLoginManagerPhd(ManagerPhdConnexion managerPhdConnexion)
    {
        ModelAndView mv=new ModelAndView();
        List<ManagerPhd> managerPhd = managerPhdConnexionRepository.checkConnexion(managerPhdConnexion.getEmail(),managerPhdConnexion.getPassword());
        if(managerPhd.size()==0)
        {
            mv.addObject("errorStatus","Error");
            mv.setViewName("loginManagerPhd.jsp");
        }
        else
        {
            mv.addObject("errorStatus","emailValid");
            mv.setViewName("homeManagerPhd.jsp");
        }
        return mv;
    }
    @Autowired
    DirectorEdmiConnexionRepository directorEdmiConnexionRepository;
    @RequestMapping("loginDirectorEdmi")
    public ModelAndView loginDirectorEdmi()
    {
        ModelAndView mv=new ModelAndView("loginPhd.jsp");
        return mv;
    }
    @RequestMapping("loginDirectorEdmiForm")
    public ModelAndView formLoginDirectorEdmi(DirectorEdmiConnexion directorEdmiConnexion)
    {
        ModelAndView mv=new ModelAndView();
        List<DirectorEdmi> directorEdmi = directorEdmiConnexionRepository.checkConnexion(directorEdmiConnexion.getEmail(),directorEdmiConnexion.getPassword());
        if(directorEdmi.size()==0)
        {
            mv.addObject("errorStatus","Error");
            mv.setViewName("loginDirectorEdmi.jsp");
        }
        else
        {
            mv.addObject("errorStatus","emailValid");
            mv.setViewName("homeDirectorEdmi.jsp");
        }
        return mv;
    }
    @Autowired
    HeadInstitutionConnexionRepository headInstitutionConnexionRepository;
    @RequestMapping("loginHeadInstitution")
    public ModelAndView loginHeadInstitution()
    {
        ModelAndView mv=new ModelAndView("loginHeadInstitution.jsp");
        return mv;
    }
    @RequestMapping("loginHeadInstitutionForm")
    public ModelAndView formLoginHeadInstitution(HeadInstitutionConnexion headInstitutionConnexion)
    {
        ModelAndView mv=new ModelAndView();
        List<HeadInstitution> headInstitution = headInstitutionConnexionRepository.checkConnexion(headInstitutionConnexion.getEmail(),headInstitutionConnexion.getPassword());
        if(headInstitution.size()==0)
        {
            mv.addObject("errorStatus","Error");
            mv.setViewName("loginHeadInstitution.jsp");
        }
        else
        {
            mv.addObject("errorStatus","emailValid");
            mv.setViewName("homeHeadInstitution.jsp");
        }
        return mv;
    }

}
