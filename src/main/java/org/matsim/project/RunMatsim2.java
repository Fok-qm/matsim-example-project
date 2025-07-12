package org.matsim.project;

import org.matsim.api.core.v01.Scenario;
import org.matsim.contrib.otfvis.OTFVisLiveModule;
import org.matsim.core.config.Config;
import org.matsim.core.config.ConfigUtils;
import org.matsim.core.controler.Controler;
import org.matsim.core.controler.OutputDirectoryHierarchy;
import org.matsim.core.scenario.ScenarioUtils;


import javax.naming.ldap.Control;

import static org.matsim.core.controler.OutputDirectoryHierarchy.OverwriteFileSetting.*;

public class RunMatsim2 {
    public static void main( String[] args){

       Config config = ConfigUtils.loadConfig("scenarios/equil/config.xml");

       config.controller().setLastIteration(10);
       config.controller().setOverwriteFileSetting(deleteDirectoryIfExists);
       config.controller().setWritePlansInterval(1);

       Scenario scenario = ScenarioUtils.loadScenario(config);

       Controler controler = new Controler(scenario);

//       controler.addOverridingModule( new OTFVisLiveModule() ) ;

       controler.run();

    }
}
