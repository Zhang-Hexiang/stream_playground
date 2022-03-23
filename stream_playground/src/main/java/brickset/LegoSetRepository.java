package brickset;

import repository.Repository;


import java.util.List;

/**
 * Represents a repository of {@code LegoSet} objects.
 */
public class LegoSetRepository extends Repository<LegoSet> {

    public LegoSetRepository() {
        super(LegoSet.class, "brickset.json");
    }

    public static void main(String[] args) {
        LegoSetRepository legoSetRepository = new LegoSetRepository();
        long piecesGreaterThan100 ;
        legoSetRepository.printLegoSetThemeIsGame();
        legoSetRepository.printLegoSetTagIncludeCartoon();
        piecesGreaterThan100 = legoSetRepository.countLegoSetGreaterThan100Pieces();
        System.out.println(piecesGreaterThan100);
        legoSetRepository.printTotalPieces();
        legoSetRepository.printLegoSetWithHeightGreatThan20();
    }


    public void testGetAll(){
        System.out.println(getAll());
    }
/**
   print the LegoSet details with the Game theme
 */

    public void printLegoSetThemeIsGame(){

        List<LegoSet> list = getAll();

        list = list.stream()
                .filter(legoSet -> legoSet.getTheme().equals("Games"))
                .toList();
        System.out.println(list);
    }

    /**
     *  print LegoSet details which tags contain Cartoon
     */
    public void printLegoSetTagIncludeCartoon(){

        List<LegoSet> list = getAll();

        list = list.stream()
                .filter(legoSet -> legoSet.getTags() != null && legoSet.getTags().contains("Cartoon"))
                .toList();

        System.out.println(list);
    }

    /**
     *returns the number of LEGO set which pieces are greater than 100
     *
     * @return the number of LEGO set which pieces are greater than 100
     */
    public Long countLegoSetGreaterThan100Pieces(){

        return getAll().stream()
                .filter(legoSet -> {
                    Integer integer = legoSet.getPieces();
                    if(integer == null){
                        return false;
                    }

                    return legoSet.getPieces() > 100;
                })
                .count();
    }
    /**
     * print the summary of all LEGO sets' pieces
     */
    public void printTotalPieces(){
        List<LegoSet> list = getAll();
        int totalPieces;
        totalPieces = list.stream()
                .mapToInt(legoSet -> legoSet.getPieces())
                .sum();
        System.out.println(totalPieces);
    }

    /**
     * print the LEGO set details which height is greater than 20
     */
    public void printLegoSetWithHeightGreatThan20(){
        List<LegoSet> list = getAll();

        list = list.stream()
                .filter(legoSet -> legoSet.getDimensions()!= null  && legoSet.getDimensions().getHeight() != null && legoSet.getDimensions().getHeight() > 20.0)
                .toList();
        System.out.println(list);
    }
}
