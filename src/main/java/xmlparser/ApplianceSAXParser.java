package xmlparser;

import appliances.Fridge;
import appliances.PC;
import appliances.Router;
import appliances.TV;
import org.xml.sax.Attributes;
import electronics.ApplianceList;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;


/**
 * Created by VladislavYTsa on 26.07.2017.
 */
public class ApplianceSAXParser extends DefaultHandler {
    private static final String APPLIANCELIST = "appliancelist";
    private static final String FRIDGE = "fridge";
    private static final String PC = "pc";
    private static final String ROUTER = "router";
    private static final String TV = "tv";
    private static final String MODELNAME = "modelName";
    private static final String POWER = "power";
    private static final String ONOFF = "onOff";
    private static final String CAPACITY = "capacity";
    private static final String CPUGHZ = "cpuGhz";
    private static final String GPU = "gpu";
    private static final String LINKSPEED = "linkSpeed";
    private static final String VLANFEATURE = "vlanFeature";
    private static final String DIAGSIZE = "diagSize";
    private static final String DISPRESOL = "dispResol";

    private String modelName = "";
    private double power;
    private boolean onOff;
    private int capacity;
    private int cpuGhz;
    private String gpu = "";
    private int linkSpeed;
    private String vlanFeature = "";
    private int diagSize;
    private String dispResol = "";

    private ApplianceList appliance;
    private String element;

    public ApplianceList xmlSAXParsing(String xmlDir) {

        try {
            SAXParserFactory parserFactory = SAXParserFactory.newInstance();
            SAXParser parser = parserFactory.newSAXParser();
            parser.parse(new File(xmlDir), this);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return appliance;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        this.element = qName;
        if (this.element.equals(APPLIANCELIST)) {
            appliance = new ApplianceList();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (!String.valueOf(ch, start, length).trim().equals("")) {
            switch (element) {
                case MODELNAME:
                    this.modelName = String.valueOf(ch, start, length);
                    break;
                case POWER:
                    this.power = Double.parseDouble(String.valueOf(ch, start, length));
                    break;
                case ONOFF:
                    this.onOff = Boolean.parseBoolean(String.valueOf(ch, start, length));
                    break;
                case CAPACITY:
                    this.capacity = Integer.parseInt(String.valueOf(ch, start, length));
                    break;
                case CPUGHZ:
                    this.cpuGhz = Integer.parseInt(String.valueOf(ch, start, length));
                    break;
                case GPU:
                    this.gpu = String.valueOf(ch, start, length);
                    break;
                case LINKSPEED:
                    this.linkSpeed = Integer.parseInt(String.valueOf(ch, start, length));
                    break;
                case VLANFEATURE:
                    this.vlanFeature = String.valueOf(ch, start, length);
                    break;
                case DIAGSIZE:
                    this.diagSize = Integer.parseInt(String.valueOf(ch, start, length));
                    break;
                case DISPRESOL:
                    this.dispResol = String.valueOf(ch, start, length);
                    break;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case FRIDGE:
                this.appliance.getAs().add(new Fridge(modelName, power, onOff, capacity));
                break;
            case PC:
                this.appliance.getAs().add(new PC(modelName, power, onOff, cpuGhz, gpu));
                break;
            case ROUTER:
                this.appliance.getAs().add(new Router(modelName, power, onOff, linkSpeed, vlanFeature));
                break;
            case TV:
                this.appliance.getAs().add(new TV(modelName, power, onOff, diagSize, dispResol));
                break;
        }
    }

    public ApplianceList getApplianceList() {
        return appliance;
    }
}
