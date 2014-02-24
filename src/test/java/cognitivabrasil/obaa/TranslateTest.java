/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cognitivabrasil.obaa;

import cognitivabrasil.obaa.Accessibility.AudioDescription;
import cognitivabrasil.obaa.Accessibility.ColorAvoidance;
import cognitivabrasil.obaa.Accessibility.LearnerScaffold;
import cognitivabrasil.obaa.Accessibility.SignLanguage;
import cognitivabrasil.obaa.Classification.Purpose;
import cognitivabrasil.obaa.Educational.Context;
import cognitivabrasil.obaa.Educational.DidaticStrategy;
import cognitivabrasil.obaa.Educational.Difficulty;
import cognitivabrasil.obaa.Educational.IntendedEndUserRole;
import cognitivabrasil.obaa.Educational.InteractionType;
import cognitivabrasil.obaa.Educational.InteractivityLevel;
import cognitivabrasil.obaa.Educational.InteractivityType;
import cognitivabrasil.obaa.Educational.LearningContentType;
import cognitivabrasil.obaa.Educational.LearningResourceType;
import cognitivabrasil.obaa.Educational.Perception;
import cognitivabrasil.obaa.Educational.Reciprocity;
import cognitivabrasil.obaa.Educational.SemanticDensity;
import cognitivabrasil.obaa.General.Structure;
import cognitivabrasil.obaa.LifeCycle.Role;
import cognitivabrasil.obaa.Relation.Kind;
import cognitivabrasil.obaa.SegmentInformationTable.GroupType;
import cognitivabrasil.obaa.SegmentInformationTable.SegmentMediaType;
import cognitivabrasil.obaa.Technical.Name;
import cognitivabrasil.obaa.Technical.SupportedPlatform;
import cognitivabrasil.obaa.Technical.Type;
import metadata.TextElement;
import org.apache.commons.lang3.text.WordUtils;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 *
 * @author Marcos Freitas Nunes <marcos@cognitivabrasil.com.br>
 */
public class TranslateTest {

    @Test
    public void BooleanElementTest() {
        BooleanElement obj = new BooleanElement();
        TestTranslate tt = new TestTranslate(obj);
        tt.setValue(BooleanElement.TRUE);
        tt.setPortuguese("Verdadeiro");
        tt.test();

        tt.setValue(BooleanElement.FALSE);
        tt.setPortuguese("Falso");
        tt.test();

        tt.setValue("yes");
        tt.setPortuguese("Sim");
        tt.test();
        
        tt.setValue("no");
        tt.setPortuguese("Não");
        tt.test();
    }

    @Test
    public void AudioDescriptionTest() {
        AudioDescription obj = new AudioDescription();
        TestTranslate tt = new TestTranslate(obj, AudioDescription.EXPANDED, "Expanded", "Expandido");
        tt.test();

        tt.setValue(AudioDescription.STANDARD);
        tt.setEnglish("Standard");
        tt.setPortuguese("Padrão");
        tt.test();
    }

    @Test
    public void ColorAvoidanceTest() {
        ColorAvoidance obj = new ColorAvoidance();
        TestTranslate tt = new TestTranslate(obj);

        tt.setValue(ColorAvoidance.AVOID_BLUE_YELLOW);
        tt.setPortuguese("Evitar Azul e Amarelo");
        tt.test();

        tt.setValue(ColorAvoidance.AVOID_ORANGE);
        tt.setPortuguese("Evitar Laranja");
        tt.test();

        tt.setValue(ColorAvoidance.AVOID_PURPLE_GRAY);
        tt.setPortuguese("Evitar Roxo e Cinza");
        tt.test();

        tt.setValue(ColorAvoidance.AVOID_RED);
        tt.setPortuguese("Evitar Vermelho");
        tt.test();

        tt.setValue(ColorAvoidance.AVOID_RED_BLACK);
        tt.setPortuguese("Evitar Vermelho e Preto");
        tt.test();

        tt.setValue(ColorAvoidance.AVOID_RED_GREEN);
        tt.setPortuguese("Evitar Vermelho e Verde");
        tt.test();

        tt.setValue(ColorAvoidance.MONOCHROME);
        tt.setPortuguese("Monocromático");
        tt.test();

        tt.setValue(ColorAvoidance.USE_MAXIMUM_CONTRAST);
        tt.setPortuguese("Usar o Máximo de Contraste");
        tt.test();
    }

    @Test
    public void LearnerScaffoldTest() {
        LearnerScaffold obj = new LearnerScaffold();
        TestTranslate tt = new TestTranslate(obj);

        tt.setValue(LearnerScaffold.ABACUS);
        tt.setPortuguese("Ábaco");
        tt.test();

        tt.setValue(LearnerScaffold.CALCULATOR);
        tt.setPortuguese("Calculadora");
        tt.test();

        tt.setValue(LearnerScaffold.DICTIONARY);
        tt.setPortuguese("Dicionário");
        tt.test();

        tt.setValue(LearnerScaffold.HOMOPHONE_CHECKER);
        tt.setPortuguese("Verificador Homófono");
        tt.test();

        tt.setValue(LearnerScaffold.MIND_MAPPING_SOFTWARE);
        tt.setPortuguese("Software de Mapa Mental");
        tt.test();

        tt.setValue(LearnerScaffold.NOTE_TAKING);
        tt.setPortuguese("Anotações");
        tt.test();

        tt.setValue(LearnerScaffold.OUTLINE_TOOL);
        tt.setPortuguese("Ferramenta de Esboço");
        tt.test();

        tt.setValue(LearnerScaffold.PEER_INTERACTION);
        tt.setPortuguese("Interação Entre Pares");
        tt.test();

        tt.setValue(LearnerScaffold.SPELL_CHECKER);
        tt.setPortuguese("Corretor Ortográfico");
        tt.test();

        tt.setValue(LearnerScaffold.THESAURUS);
        tt.setPortuguese("Thesaurus");
        tt.test();
    }

    @Test
    public void LearnerSignLanguage() {
        SignLanguage obj = new SignLanguage();
        TestTranslate tt = new TestTranslate(obj);

        tt.setValue(SignLanguage.AMERICAN_ASL);
        tt.setEnglish(SignLanguage.AMERICAN_ASL);
        tt.setPortuguese("Americano-ASL");
        tt.test();

        tt.setValue(SignLanguage.AUSTRALIAN_AUSLAN);
        tt.setEnglish(SignLanguage.AUSTRALIAN_AUSLAN);
        tt.setPortuguese("Australiano-Auslan");
        tt.test();

        tt.setValue(SignLanguage.AUSTRIAN_ASQ);
        tt.setEnglish(SignLanguage.AUSTRIAN_ASQ);
        tt.setPortuguese("Austríaco-ASQ");
        tt.test();

        tt.setValue(SignLanguage.BRASILIAN_LIBRAS);
        tt.setEnglish(SignLanguage.BRASILIAN_LIBRAS);
        tt.setPortuguese("Brasileiro-LIBRAS");
        tt.test();

        tt.setValue(SignLanguage.BRITISH_BSL);
        tt.setEnglish(SignLanguage.BRITISH_BSL);
        tt.setPortuguese("Britânico-BSL");
        tt.test();

        tt.setValue(SignLanguage.DANISH_DSL);
        tt.setEnglish(SignLanguage.DANISH_DSL);
        tt.setPortuguese("Dinamarquês-DSL");
        tt.test();

        tt.setValue(SignLanguage.FRENCH_LSF);
        tt.setEnglish(SignLanguage.FRENCH_LSF);
        tt.setPortuguese("Francês-LSF");
        tt.test();

        tt.setValue(SignLanguage.GERMAN_DGS);
        tt.setEnglish(SignLanguage.GERMAN_DGS);
        tt.setPortuguese("Alemão-DGS");
        tt.test();

        tt.setValue(SignLanguage.IRISH_ISL);
        tt.setEnglish(SignLanguage.IRISH_ISL);
        tt.setPortuguese("Irlandês-ISL");
        tt.test();

        tt.setValue(SignLanguage.ITALIAN_LIS);
        tt.setEnglish(SignLanguage.ITALIAN_LIS);
        tt.setPortuguese("Italiano-LIS");
        tt.test();

        tt.setValue(SignLanguage.JAPANESE_JSL);
        tt.setEnglish(SignLanguage.JAPANESE_JSL);
        tt.setPortuguese("Japonês-JSL");
        tt.test();

        tt.setValue(SignLanguage.MALAYSIAN_MSL);
        tt.setEnglish(SignLanguage.MALAYSIAN_MSL);
        tt.setPortuguese("Malaio-MSL");
        tt.test();

        tt.setValue(SignLanguage.MEXICAN_LSM);
        tt.setEnglish(SignLanguage.MEXICAN_LSM);
        tt.setPortuguese("Mexicano-LSM");
        tt.test();

        tt.setValue(SignLanguage.NATIVE_AMERICAN);
        tt.setEnglish(SignLanguage.NATIVE_AMERICAN);
        tt.setPortuguese("Americano Nativo");
        tt.test();

        tt.setValue(SignLanguage.NETHERLANDS_NGT);
        tt.setEnglish(SignLanguage.NETHERLANDS_NGT);
        tt.setPortuguese("Holandês-NGT");
        tt.test();

        tt.setValue(SignLanguage.NORWEGIAN_NSL);
        tt.setEnglish(SignLanguage.NORWEGIAN_NSL);
        tt.setPortuguese("Norueguês-NSL");
        tt.test();

        tt.setValue(SignLanguage.OTHER);
        tt.setPortuguese("Outro");
        tt.test();
    }

    @Test
    public void PurposeTest() {

        Purpose obj = new Purpose();
        TestTranslate tt = new TestTranslate(obj, Purpose.ACCESSIBILITY, "Accessibility", "Acessibilidade");
        tt.test();

        tt.setValue(Purpose.COMPETENCY);
        tt.setPortuguese("Competência");
        tt.test();

        tt.setValue(Purpose.DISCIPLINE);
        tt.setPortuguese("Disciplina");
        tt.test();

        tt.setValue(Purpose.EDUCATIONAL_LEVEL);
        tt.setPortuguese("Nível Educacional");
        tt.test();

        tt.setValue(Purpose.EDUCATIONAL_OBJECTIVE);
        tt.setPortuguese("Objetivo Educacional");
        tt.test();

        tt.setValue(Purpose.IDEA);
        tt.setPortuguese("Ideia");
        tt.test();

        tt.setValue(Purpose.PREREQUISITE);
        tt.setPortuguese("Pré-requisito");
        tt.test();

        tt.setValue(Purpose.RESTRICTIONS);
        tt.setPortuguese("Restrições");
        tt.test();

        tt.setValue(Purpose.SECURITY_LEVEL);
        tt.setPortuguese("Nível de Segurança");
        tt.test();

        tt.setValue(Purpose.SKILL_LEVEL);
        tt.setPortuguese("Nível de Habilidade");
        tt.test();

    }

    @Test
    public void testContext() {
        Context obj = new Context();
        TestTranslate tt = new TestTranslate(obj);

        tt.setValue(Context.HIGHER_EDUCATION);
        tt.setPortuguese("Ensino Superior");
        tt.test();

        tt.setValue(Context.OTHER);
        tt.setPortuguese("Outro");
        tt.test();

        tt.setValue(Context.SCHOOL);
        tt.setPortuguese("Escola");
        tt.test();

        tt.setValue(Context.TRAINING);
        tt.setPortuguese("Treinamento");
        tt.test();
    }

    @Test
    public void testDidaticStrategy() {
        DidaticStrategy obj = new DidaticStrategy();
        TestTranslate tt = new TestTranslate(obj);

        tt.setValue(DidaticStrategy.CASE_STUDY);
        tt.setPortuguese("Estudo de Caso");
        tt.test();

        tt.setValue(DidaticStrategy.CHALLENGE);
        tt.setPortuguese("Desafio");
        tt.test();

        tt.setValue(DidaticStrategy.HYPOTHESIS_AND_TEST_DEVELOPMENT);
        tt.setEnglish("Hypothesis and Test Development");
        tt.setPortuguese("Hipótese e Desenvolvimento de Teste");
        tt.test();

        tt.setValue(DidaticStrategy.MODEL_CONSTRUCTION);
        tt.setPortuguese("Construção de Modelo");
        tt.test();

        tt.setValue(DidaticStrategy.PROBLEM_SOLVING);
        tt.setPortuguese("Resolução de Problema");
        tt.test();

        tt.setValue(DidaticStrategy.QUESTION_AND_ANSWERING);
        tt.setEnglish("Question and Answering");
        tt.setPortuguese("Perguntas e Respostas");
        tt.test();
    }

    @Test
    public void testDifficult() {
        Difficulty obj = new Difficulty();
        TestTranslate tt = new TestTranslate(obj);

        tt.setValue(Difficulty.DIFFICULT);
        tt.setPortuguese("Difícil");
        tt.test();

        tt.setValue(Difficulty.EASY);
        tt.setPortuguese("Fácil");
        tt.test();

        tt.setValue(Difficulty.MEDIUM);
        tt.setPortuguese("Médio");
        tt.test();

        tt.setValue(Difficulty.VERY_DIFFICULT);
        tt.setPortuguese("Muito Difícil");
        tt.test();

        tt.setValue(Difficulty.VERY_EASY);
        tt.setPortuguese("Muito Fácil");
        tt.test();
    }

    @Test
    public void testIntendedEndUserRole() {
        IntendedEndUserRole obj = new IntendedEndUserRole();
        TestTranslate tt = new TestTranslate(obj);

        tt.setValue(IntendedEndUserRole.AUTHOR);
        tt.setPortuguese("Autor");
        tt.test();

        tt.setValue(IntendedEndUserRole.LEARNER);
        tt.setPortuguese("Estudante");
        tt.test();

        tt.setValue(IntendedEndUserRole.MANAGER);
        tt.setPortuguese("Gestor");
        tt.test();

        tt.setValue(IntendedEndUserRole.TEACHER);
        tt.setPortuguese("Professor");
        tt.test();
    }

    @Test
    public void testInteractionType() {
        InteractionType obj = new InteractionType();
        TestTranslate tt = new TestTranslate(obj);

        tt.setValue(InteractionType.OBJECT_INDIVIDUAL);
        tt.setEnglish("Object - Individual");
        tt.setPortuguese("Objeto - Sujeito");
        tt.test();

        tt.setValue(InteractionType.INDIVIDUAL1_INDIVIDUAL2_OBJECT);
        tt.setEnglish("Individual1 - Individual2 - Object");
        tt.setPortuguese("Sujeito1 - Sujeito2 - Objeto");
        tt.test();
    }

    @Test
    public void testInteractivityLevel() {
        InteractivityLevel obj = new InteractivityLevel();
        TestTranslate tt = new TestTranslate(obj);

        tt.setValue(InteractivityLevel.HIGH);
        tt.setPortuguese("Alto");
        tt.test();

        tt.setValue(InteractivityLevel.LOW);
        tt.setPortuguese("Baixo");
        tt.test();

        tt.setValue(InteractivityLevel.MEDIUM);
        tt.setPortuguese("Médio");
        tt.test();

        tt.setValue(InteractivityLevel.VERY_HIGH);
        tt.setPortuguese("Muito Alto");
        tt.test();

        tt.setValue(InteractivityLevel.VERY_LOW);
        tt.setPortuguese("Muito Baixo");
        tt.test();
    }

    @Test
    public void testInteractivityType() {
        InteractivityType obj = new InteractivityType();
        TestTranslate tt = new TestTranslate(obj);

        tt.setValue(InteractivityType.ACTIVE);
        tt.setPortuguese("Ativa");
        tt.test();

        tt.setValue(InteractivityType.EXPOSITIVE);
        tt.setPortuguese("Expositiva");
        tt.test();

        tt.setValue(InteractivityType.MIXED);
        tt.setPortuguese("Mista");
        tt.test();
    }

    @Test
    public void testLearningContentType() {
        LearningContentType obj = new LearningContentType();
        TestTranslate tt = new TestTranslate(obj);

        tt.setValue(LearningContentType.ATITUDINAL);
        tt.setEnglish("Attitudinal");
        tt.setPortuguese("Atitudinal");
        tt.test();

        tt.setValue(LearningContentType.CONCEITUAL);
        tt.setEnglish("Conceptual");
        tt.setPortuguese("Conceitual");
        tt.test();

        tt.setValue(LearningContentType.FACTUAL);
        tt.setPortuguese("Factual");
        tt.test();

        tt.setValue(LearningContentType.PROCEDIMENTAL);
        tt.setPortuguese("Procedimental");
        tt.test();
    }

    @Test
    public void testLearningResourceType() {
        LearningResourceType obj = new LearningResourceType();
        TestTranslate tt = new TestTranslate(obj);

        tt.setValue(LearningResourceType.DIAGRAM);
        tt.setPortuguese("Diagrama");
        tt.test();

        tt.setValue(LearningResourceType.EXAM);
        tt.setPortuguese("Prova");
        tt.test();

        tt.setValue(LearningResourceType.EXERCISE);
        tt.setPortuguese("Exercício");
        tt.test();

        tt.setValue(LearningResourceType.EXPERIMENT);
        tt.setPortuguese("Experimento");
        tt.test();

        tt.setValue(LearningResourceType.FIGURE);
        tt.setPortuguese("Figura");
        tt.test();

        tt.setValue(LearningResourceType.GRAPH);
        tt.setPortuguese("Gráfico");
        tt.test();

        tt.setValue(LearningResourceType.INDEX);
        tt.setPortuguese("Índice");
        tt.test();

        tt.setValue(LearningResourceType.LECTURE);
        tt.setPortuguese("Aula");
        tt.test();

        tt.setValue(LearningResourceType.NARRATIVE_TEXT);
        tt.setPortuguese("Texto Narrativo");
        tt.test();

        tt.setValue(LearningResourceType.PROBLEM_STATEMENT);
        tt.setPortuguese("Enunciado da Questão");
        tt.test();

        tt.setValue(LearningResourceType.QUESTIONNAIRE);
        tt.setPortuguese("Questionário");
        tt.test();

        tt.setValue(LearningResourceType.SELF_ASSESSMENT);
        tt.setPortuguese("Autoavaliação");
        tt.test();

        tt.setValue(LearningResourceType.SIMULATION);
        tt.setPortuguese("Simulação");
        tt.test();

        tt.setValue(LearningResourceType.SLIDE);
        tt.setPortuguese("Slide");
        tt.test();

        tt.setValue(LearningResourceType.TABLE);
        tt.setPortuguese("Tabela");
        tt.test();
    }

    @Test
    public void testPercepsion() {
        Perception obj = new Perception();
        TestTranslate tt = new TestTranslate(obj);

        tt.setValue(Perception.AUDITIVE);
        tt.setPortuguese("Auditiva");
        tt.test();

        tt.setValue(Perception.MIXED);
        tt.setPortuguese("Mista");
        tt.test();

        tt.setValue(Perception.OTHER);
        tt.setPortuguese("Outro");
        tt.test();

        tt.setValue(Perception.VISUAL);
        tt.setPortuguese("Visual");
        tt.test();
    }

    @Test
    public void testReciprocity() {
        Reciprocity obj = new Reciprocity();
        TestTranslate tt = new TestTranslate(obj);

        tt.setValue(Reciprocity.N_M);
        tt.setEnglish("n-m");
        tt.setPortuguese("n-m");
        tt.test();

        tt.setValue(Reciprocity.ONE_N);
        tt.setEnglish("1-n");
        tt.setPortuguese("1-n");
        tt.test();

        tt.setValue(Reciprocity.ONE_ONE);
        tt.setEnglish("1-1");
        tt.setPortuguese("1-1");
        tt.test();
    }

    @Test
    public void testSemanticDensity() {
        SemanticDensity obj = new SemanticDensity();
        TestTranslate tt = new TestTranslate(obj);

        tt.setValue(SemanticDensity.HIGH);
        tt.setPortuguese("Alto");
        tt.test();

        tt.setValue(SemanticDensity.LOW);
        tt.setPortuguese("Baixo");
        tt.test();

        tt.setValue(SemanticDensity.MEDIUM);
        tt.setPortuguese("Médio");
        tt.test();

        tt.setValue(SemanticDensity.VERY_HIGH);
        tt.setPortuguese("Muito Alto");
        tt.test();

        tt.setValue(SemanticDensity.VERY_LOW);
        tt.setPortuguese("Muito Baixo");
        tt.test();
    }

    @Test
    public void testStructure() {
        Structure obj = new Structure();
        TestTranslate tt = new TestTranslate(obj);

        tt.setValue(Structure.ATOMIC);
        tt.setPortuguese("Atômico");
        tt.test();

        tt.setValue(Structure.COLLECTION);
        tt.setPortuguese("Coleção");
        tt.test();

        tt.setValue(Structure.HIERARCHICAL);
        tt.setPortuguese("Hierárquico");
        tt.test();

        tt.setValue(Structure.LINEAR);
        tt.setPortuguese("Linear");
        tt.test();

        tt.setValue(Structure.NETWORKED);
        tt.setPortuguese("Em Rede");
        tt.test();
    }

    @Test
    public void testRole() {
        Role obj = new Role();
        TestTranslate tt = new TestTranslate(obj);

        tt.setValue(Role.AUTHOR);
        tt.setPortuguese("Autor");
        tt.test();

        tt.setValue(Role.CONTENT_PROVIDER);
        tt.setPortuguese("Provedor de Conteúdo");
        tt.test();

        tt.setValue(Role.EDITOR);
        tt.setPortuguese("Editor");
        tt.test();

        tt.setValue(Role.EDUCATIONAL_VALIDATOR);
        tt.setPortuguese("Validador Educacional");
        tt.test();

        tt.setValue(Role.GRAPHICAL_DESIGNER);
        tt.setPortuguese("Designer Gráfico");
        tt.test();

        tt.setValue(Role.INITIATOR);
        tt.setPortuguese("Iniciador");
        tt.test();

        tt.setValue(Role.INSTRUCTIONAL_DESIGNER);
        tt.setPortuguese("Designer Instrucional");
        tt.test();

        tt.setValue(Role.PUBLISHER);
        tt.setPortuguese("Publicador");
        tt.test();

        tt.setValue(Role.SCRIPT_WRITER);
        tt.setPortuguese("Roteirista");
        tt.test();

        tt.setValue(Role.SUBJECT_MATTER_EXPERT);
        tt.setPortuguese("Especialista na Área");
        tt.test();

        tt.setValue(Role.TECHNICAL_IMPLEMENTER);
        tt.setPortuguese("Programador");
        tt.test();

        tt.setValue(Role.TECHNICAL_VALIDATOR);
        tt.setPortuguese("Validador Técnico");
        tt.test();

        tt.setValue(Role.TERMINATOR);
        tt.setPortuguese("Eliminador");
        tt.test();

        tt.setValue(Role.UNKNOWN);
        tt.setPortuguese("Desconhecido");
        tt.test();

        tt.setValue(Role.VALIDATOR);
        tt.setPortuguese("Validador");
        tt.test();
    }

    @Test
    public void testMetaRole() {
        cognitivabrasil.obaa.Metametadata.Role obj = new cognitivabrasil.obaa.Metametadata.Role();
        TestTranslate tt = new TestTranslate(obj);

        tt.setValue(cognitivabrasil.obaa.Metametadata.Role.CREATOR);
        tt.setPortuguese("Criador");
        tt.test();

        tt.setValue(cognitivabrasil.obaa.Metametadata.Role.UNKNOWN);
        tt.setPortuguese("Desconhecido");
        tt.test();

        tt.setValue(cognitivabrasil.obaa.Metametadata.Role.VALIDATOR);
        tt.setPortuguese("Validador");
        tt.test();
    }

    @Test
    public void testKind() {
        Kind obj = new Kind();
        TestTranslate tt = new TestTranslate(obj);

        tt.setValue(Kind.HAS_FORMAT);
        tt.setEnglish("Has Format");
        tt.setPortuguese("Tem Formatos");
        tt.test();

        tt.setValue(Kind.HAS_PART);
        tt.setEnglish("Has Part");
        tt.setPortuguese("Tem Partes");
        tt.test();

        tt.setValue(Kind.HAS_VERSION);
        tt.setEnglish("Has Version");
        tt.setPortuguese("Tem Versões");
        tt.test();

        tt.setValue(Kind.IS_BASED_ON);
        tt.setEnglish("Is Based on");
        tt.setPortuguese("É Baseado em");
        tt.test();

        tt.setValue(Kind.IS_BASIS_FOR);
        tt.setEnglish("Is Basis for");
        tt.setPortuguese("É Base para");
        tt.test();

        tt.setValue(Kind.IS_FORMAT_OF);
        tt.setEnglish("Is Format of");
        tt.setPortuguese("É Formato de");
        tt.test();

        tt.setValue(Kind.IS_PART_OF);
        tt.setEnglish("Is Part of");
        tt.setPortuguese("É Parte de");
        tt.test();

        tt.setValue(Kind.IS_REFERENCED_BY);
        tt.setEnglish("Is Referenced by");
        tt.setPortuguese("É Referenciado por");
        tt.test();

        tt.setValue(Kind.IS_REQUIRED_BY);
        tt.setEnglish("Is Required by");
        tt.setPortuguese("É Requerido por");
        tt.test();

        tt.setValue(Kind.IS_VERSION_OF);
        tt.setEnglish("Is Version of");
        tt.setPortuguese("É Versão de");
        tt.test();

        tt.setValue(Kind.REFERENCES);
        tt.setPortuguese("Referencia");
        tt.test();

        tt.setValue(Kind.REQUIRES);
        tt.setPortuguese("Requer");
        tt.test();
    }

    @Test
    public void testSegmentMediaType() {
        SegmentMediaType obj = new SegmentMediaType();
        TestTranslate tt = new TestTranslate(obj);

        tt.setValue(SegmentMediaType.AUDIO);
        tt.setPortuguese("Áudio");
        tt.test();

        tt.setValue(SegmentMediaType.DOCUMENT);
        tt.setPortuguese("Documento");
        tt.test();

        tt.setValue(SegmentMediaType.HYPERDOCUMENT);
        tt.setPortuguese("Hiperdocumento");
        tt.test();

        tt.setValue(SegmentMediaType.OTHER);
        tt.setPortuguese("Outro");
        tt.test();

        tt.setValue(SegmentMediaType.VIDEO);
        tt.setPortuguese("Vídeo");
        tt.test();
    }

    @Test
    public void testName() {
        Name obj = new Name();
        TestTranslate tt = new TestTranslate(obj);

        tt.setValue(Name.AMAYA);
        tt.setPortuguese("Amaya");
        tt.test();

        tt.setValue(Name.ANY);
        tt.setPortuguese("Qualquer");
        tt.test();

        tt.setValue(Name.APPLE_SAFARI);
        tt.setEnglish("Safari");
        tt.setPortuguese("Safari");
        tt.test();

        tt.setValue(Name.GOOGLE_CHROME);
        tt.setPortuguese("Google Chrome");
        tt.test();

        tt.setValue(Name.MACOS);
        tt.setEnglish("Mac OS");
        tt.setPortuguese("Mac OS");
        tt.test();

        tt.setValue(Name.MOZILLA_FIREFOX);
        tt.setEnglish("Firefox");
        tt.setPortuguese("Firefox");
        tt.test();

        tt.setValue(Name.MS_INTERNET_EXPLORER);
        tt.setEnglish("Internet Explorer");
        tt.setPortuguese("Internet Explorer");
        tt.test();

        tt.setValue(Name.MS_WINDOWS);
        tt.setEnglish("Windows");
        tt.setPortuguese("Windows");
        tt.test();

        tt.setValue(Name.MULTI_OS);
        tt.setEnglish("Multi OS");
        tt.setPortuguese("Multi OS");
        tt.test();

        tt.setValue(Name.NETSCAPE_COMUNICATOR);
        tt.setEnglish("Netscape");
        tt.setPortuguese("Netscape");
        tt.test();

        tt.setValue(Name.NONE);
        tt.setPortuguese("Nenhum");
        tt.test();

        tt.setValue(Name.OPERA);
        tt.setPortuguese("Opera");
        tt.test();

        tt.setValue(Name.PC_DOS);
        tt.setEnglish("DOS");
        tt.setPortuguese("DOS");
        tt.test();

        tt.setValue(Name.UNIX);
        tt.setPortuguese("Unix");
        tt.test();

        tt.setValue(Name.GINGA);
        tt.setEnglish("GINGA");
        tt.setPortuguese("GINGA");

        tt.setValue(Name.MHP);
        tt.setEnglish("MHP");
        tt.setPortuguese("MHP");
        tt.test();

        tt.setValue(Name.ARIB);
        tt.setEnglish("ARIB");
        tt.setPortuguese("ARIB");
        tt.test();

        tt.setValue(Name.DAVIC);
        tt.setEnglish("SAVIC");
        tt.setPortuguese("SAVIC");
        tt.test();

        tt.setValue(Name.DASE);
        tt.setEnglish("DASE");
        tt.setPortuguese("DASE");
        tt.test();

        tt.setValue(Name.GEM);
        tt.setEnglish("GEM");
        tt.setPortuguese("GEM");
        tt.test();
    }

    @Test
    public void TypeTest() {
        Type obj = new Type();
        TestTranslate tt = new TestTranslate(obj);

        tt.setValue(Type.BROWSER);
        tt.setPortuguese("Navegador");
        tt.test();

        tt.setValue(Type.MIDDLEWARE);
        tt.setPortuguese("Middleware");
        tt.test();

        tt.setValue(Type.OPERATING_SYSTEM);
        tt.setPortuguese("Sistema Operacional");
        tt.test();
    }

    @Test
    public void SupportedPlatformTest() {
        SupportedPlatform obj = new SupportedPlatform();
        TestTranslate tt = new TestTranslate(obj);

        tt.setValue(SupportedPlatform.DTV);
        tt.setEnglish("Digital TV");
        tt.setPortuguese("TV Digital");

        tt.setValue(SupportedPlatform.MOBILE);
        tt.setPortuguese("Móveis");

        tt.setValue(SupportedPlatform.WEB);
        tt.setPortuguese("Web");
    }
    
    @Test
    public void GroupTypeTest() {
        GroupType obj = new GroupType();
        TestTranslate tt = new TestTranslate(obj);

        tt.setValue(GroupType.ACTIVITIES);
        tt.setPortuguese("Atividades");
        tt.test();
        
        tt.setValue(GroupType.BOOKMARKS);
        tt.setPortuguese("Favoritos");
        tt.test();
        
        tt.setValue(GroupType.HIGHLIGHTS);
        tt.setPortuguese("Melhores Momentos");
        tt.test();
        
        tt.setValue(GroupType.OTHER);
        tt.setPortuguese("Outro");
        tt.test();
        
        tt.setValue(GroupType.PREVIEW);
        tt.setPortuguese("Visualização");
        tt.test();
        
        tt.setValue(GroupType.THEME_GROUP);
        tt.setPortuguese("Grupo Temático");
        tt.test();
    }

}

class TestTranslate {

    private TextElement obj;
    private String value;
    private String english;
    private String portuguese;

    public TestTranslate(TextElement obj, String value, String english, String portuguese) {
        this.obj = obj;
        this.value = value;
        this.english = english;
        this.portuguese = portuguese;
    }

    public TestTranslate(TextElement obj) {
        this.obj = obj;
    }

    public void setObj(TextElement obj) {
        this.obj = obj;
    }

    public void setValue(String value) {
        this.value = value;
        this.english = null;
        this.portuguese = null;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public void setPortuguese(String portuguese) {
        this.portuguese = portuguese;
    }

    public void test() {
        obj.setText(value);
        obj.setLanguage("en");
        if (english == null || english.isEmpty()) {
            english = WordUtils.capitalizeFully(value.replaceAll("_", " "), ' ', '-'); //transforma a todas as primeiras letras em maiusculo e as letras depois do hifen tb.
        }
        assertThat(obj.toString(), equalTo(english));
        obj.setLanguage("pt-BR");
        assertThat(obj.toString(), equalTo(portuguese));
    }
}
