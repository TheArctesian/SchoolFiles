import json
cog = ["Multi-Store Model",
        "Working Memory Model",
        "Schema",
        "Dual Process Model of Thinking and Decision Making",
        "Englich & Mussweller (2001)"
        "Alter et Al(2007)",
        "Loftus & Pickrell (1974)",
        "Yuillie & Cutshall (1986)",
        "Loftus & Palmer",
        "Reconstructive Memory",
        "Cognitive bias",
        "Tversky & Kahneman (1974)",
        "Cahill & McGuagh (1995)",
        "Bartlett (1932)",
        "HM"
        "Strack and Mussweiller",
        "Confirmation Bias",
        "Cognitive Dissonance",
        "Anchoring Bias",
        "Just World Hypothesis",
        "Optimism Bias",
        "Fundemental Attribution",
        "Framing Effect",
        "Self-Serving Bias",
        "Dunning-Kruger Effect",
        "Barnum Effect",
        "Halo Effect",
        "Sunk cost fallacy",
        "Illusory correlations",
        "Availability Heuristic",
        "In-group bias",
        "Bystander Effect"
       ]

abnorm = ["Genetics",
          "Kendler",
          "Comorbidity",
          "Serotonin Hypothesis",
          "Cortisol Hypothesis",
          "Vulnerability factors",
          "Protective factors",
          "Aaron Beck",
          "Alloy",
          "Joiner",
          "Brown & Harris",
          "prevalence",
          "emic",
          "rumination",
          "etic",
          "Incidence",
          'CBT',
          "Prevelence",
          "Diasthesis-stress model",
          "MDD",
          ]

bio = ['Localization of Function',
       'Neuroplasticity',
       'Neurotransmitter',
       'Agonist',
       'Evolution',
       'Antagonist',
       'Hormone',
       'Pheromone',
       'Genetics',
       'Adrenaline',
       'Acetylcholine',
       'Eugene Pauly',
       'HM',
       'Caspi',
       'Maguire',
       'Rosenzweig, Bennet & Diamond',
       'Kendler',
       'Weissman et al 2005',
       'Wedekind',
       'Cahill & McGaugh']


socul = ["Social identity theory",
         "Social cognitive theory",
         "Illusory Correlation",
         "Steele & Aronson (1995)"
         "Levels of Culture",
         "Cultural Norms",
         "Enculturation",
         "Direct Model SCT",
         "Indirect Model SCT",
         "Vicarious Reinforcment SCT",
         "Enculturation",
         "Stereotypes",
         "Cultural dimensions",
         "Acculturation",
         "Bandura",
         "Tajfel",
         "Festmger et al (1956)",
         "Hamilton & Gifford"
         ]

EMT = ["Protection from undue harm",
       "consent",
       "debrief",
       "confidentiality",
       "anonymity",
       "natural experiment",
       "quasi experiment",
       "survey",
       "meta-analysis",
       "questionnaire",
       "semi-structured interview",
       "unstructured interview",
       "structured interview"]

BioERQ = [
"Discuss/evaluate/contrast research methods used to study the brain in relation to behaviour.",
"Discuss ethical considerations relevant to the study of the brain in relation to behaviour.",
"Discuss techniques used to study the brain in relation to behavior.",
"Discuss/evaluate the theory of localization of function, with reference to relevant research.",
"Discuss neuroplasticity and related research.",
"Discuss the effect of one or more neurotransmitters on behaviour.",
"Discuss/evaluate/contrast research methods used to study hormones in relation to behaviour.",
"Discuss ethical considerations relevant to the study of hormones in relation to behaviour.",
"Discuss the effect of one or more hormones on behaviour.",
"To what extent do pheromones affect human behaviour?",
"Discuss/evaluate/contrast research methods used to study the role of genetics in behaviour.",
"Discuss ethical considerations relevant to the study of the role of genetics in behaviour.",
"Discuss the role of genes in one or more behaviours.",
"To what extent does genetic inheritance/similarity influence human behaviour?",
"Evaluate one evolutionary explanation for behaviour, using relevant research.",
]

CogERQ = [
"Discuss/evaluate/contrast research methods used to study cognitive processing.",
"Discuss ethical considerations relevant to the study of cognitive processing.",
"Evaluate one model of memory.",
"Contrast two models of memory.",
"Evaluate Schema Theory.",
"Evaluate one model of thinking and decision-making.",
"Discuss/evaluate/contrast research methods used to study the reliability cognitive processes.",
"Discuss ethical considerations relevant to the study of the reliability of cognitive processes.",
"To what extent is memory reconstructive?",
"Evaluate one or more explanations for biases in thinking and/or decision-making.",
"Discuss/evaluate/contrast research methods used to study the role of emotion in cognition.",
"Discuss ethical considerations relevant to the study of emotion and cognition.",
"To what extent does emotion influence one or more cognitive processes? ",
"Discuss the role of emotion in one or more cognitive processes.",
        ] 

SoculERQ = [
"Discuss/evaluate/contrast research methods used to study the individual and the group.",
"Discuss ethical considerations relevant to the study of the individual and the group.",
"Evaluate Social Identity Theory.",
"To what extent can Social Cognitive Theory explain individual behaviour?",
"Discuss the formation of stereotypes and/or the effect(s) of stereotypes on human behaviour.",
"Discuss/evaluate/contrast research methods used to study the role of culture in behaviour.",
"Discuss ethical considerations relevant to the study of the role of culture in behaviour.",
"To what extent does culture influence behaviour and/or cognition?",
"Discuss the influence of one or more cultural dimensions on behaviour.",
"Discuss/evaluate research on Enculturation.",
"Discuss/evaluate research on Acculturation.",
]
AbnormERQ = ["Discuss a biological approach to explaining the etiology of one disorder.",
"Discuss a cognitive approach to explaining the etiology of one disorder.",
"Discuss a sociocultural approach to explaining the etiology of one disorder.",
"Discuss ethical considerations in the study the etiology of disorders.",
"Discuss approaches to research in the study the etiology of disorders.",
"Discuss one etiology of one disorder.",
"Discuss prevalence rates of disorders.",
"Discuss one biological approach to the treatment of disorders.",
"Discuss one cognitive approach to the treatment of disorders.",
"Discuss ethical considerations in the treatment of disorders.",
"Discuss approaches to research in the study of the treatment of disorders."
]


print("Cog length: ", len(cog))
print("Abnormal length: ", len(abnorm))
print("Bio length: ", len(bio))
print("Socul Length: ", len(socul))
print("EMT Length: ", len(EMT))

class Card: 
    def __init__(self, Cog, Abnor, Socul, Bio, EMT, ERQ):
        self.Cog = Cog
        self.Bio = Bio
        self.Socul = Socul
        self.Abnor = Abnor
        self.EMT = EMT
        self.ERQ = ERQ
    def dict(self):
        c = {
            "Cognitive" : self.Cog,
            "Biological":self.Bio,
            "SocioCultural" : self.Socul,
            "Abnormal" : self.Abnor,
            "Ethics and Res Methods" : Self.EMT,
            "Random ERQ" : self.ERQ
        }

cards = []


def initCard():
    c = Card()     
def concatList():
    for  

# make enough arrays for cards
