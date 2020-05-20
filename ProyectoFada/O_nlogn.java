package ProyectoFada;
import java.util.Arrays;

/**
 * para la complejidad O(nlogn) se usara el merge sort para hacerlo,
 * modificandolo para que ordene el array de los nombres en funcion de su
 * importancia
 * 
 * @author CamiloRosero
 * @author MariaArroyo
 * @author JoseErazo
 * 
 */

public class O_nlogn {
	
	 private int n,m,k;
	    private String[] anim;
	    private int[]grand;
	    private String[][]aper;
	    private String[][][]part;    
	    
	    public O_nlogn(int no,int p,int e, String[] a, int[] g,String[][] apr,String[][][] pa){      

	    	n=no; //6
	        m=p;  //3
	        k=e;  //2
	        int auxn;
	        anim= new String[n];
	        grand=new int[n];
	        aper=new String[(m-1)*k][3];
	        part=new String[m-1][k][3];
	        int[] aux = new int[3];
	        int[] aux2 = new int[k];
	        for (int i=0;i<n;i++){
	            anim[i]=a[i];
	            grand[i]=g[i];
	        }
	        sort(grand,anim,0,n);
	        for (int i=0;i<((m-1)*k);i++){
	            for (int j=0;j<3;j++){
	                aper[i][j]=apr[i][j];
	                auxn=indf(aper[i][j]);
	                aux[j]=auxn;
	            }
	            sort(aux,aper[i],0,((m-1)*k)-1);
	            
	        }
	        for (int i=0;i<(m-1);i++){
	            for (int j=0;j<k;j++){
	                for (int w=0;w<3;w++){
	                part[i][j][w]=pa[i][j][w];
	                auxn=indf(part[i][j][w]);
	                aux[w]=auxn;
	                aux2[j]=aux2[j]+auxn;
	                }
	                sort(aux,part[i][j],0,3);
	            }
	            //sortar(aux2,part[i],0,k-1);
	        }
	        
	        System.out.print("la presentacion tiene "+n+" animales en total,y consta de "+m+" partes de "
	                +k+" escenas \n");
	                
	                System.out.print("el orden en el que hace la prsentacion es: \n");
	                
	                System.out.print("apertura :");
	                
	                for(int w=((m-1)*k)-1;w>=0;w--) {
	                	System.out.print("[ ");
	                	for(int t=0;t<3;t++) {
	                		System.out.print(aper[w][t]+ ", ");
	                	}
	                	System.out.print("] ");
	                }
                        
                        System.out.print("\n");
                        
	                for(int w=(m-2);w>=0;w--) {
                            int d = m-w-1;
	                	System.out.print("parte"+d+": ");
	                	for(int t=0;t<k;t++) {
	                		System.out.print("escena"+k+": [ ");
	                		for(int f=0;f<3;f++) {
	                			System.out.print( part[w][t][f] +", ");
	                		}
                                 System.out.print("] ");     
	                	}
	                	System.out.print("\n");
	                }        	        
	        
	    }
	    
	 // Merges two subarrays of arr[]. 
	    // First subarray is arr[l..m] 
	    // Second subarray is arr[m+1..r] 
	    void merge(int arr[], int l, int m, int r) 
	    { 
	        // Find sizes of two subarrays to be merged 
	        int n1 = m - l + 1; 
	        int n2 = r - m; 
	  
	        /* Create temp arrays */
	        int L[] = new int [n1]; 
	        int R[] = new int [n2]; 
	  
	        /*Copy data to temp arrays*/
	        for (int i=0; i<n1; ++i) 
	            L[i] = arr[l + i]; 
	        for (int j=0; j<n2; ++j) 
	            R[j] = arr[m + 1+ j]; 
	  
	  
	        /* Merge the temp arrays */
	  
	        // Initial indexes of first and second subarrays 
	        int i = 0, j = 0; 
	  
	        // Initial index of merged subarry array 
	        int k = l; 
	        while (i < n1 && j < n2) 
	        { 
	            if (L[i] <= R[j]) 
	            { 
	                arr[k] = L[i]; 
	                i++; 
	            } 
	            else
	            { 
	                arr[k] = R[j]; 
	                j++; 
	            } 
	            k++; 
	        } 
	  
	        /* Copy remaining elements of L[] if any */
	        while (i < n1) 
	        { 
	            arr[k] = L[i]; 
	            i++; 
	            k++; 
	        } 
	  
	        /* Copy remaining elements of R[] if any */
	        while (j < n2) 
	        { 
	            arr[k] = R[j]; 
	            j++; 
	            k++; 
	        } 
	    } 
	  
	    // Main function that sorts arr[l..r] using 
	    // merge() 
	    void sort(int arr[], int l, int r) 
	    { 
	        if (l < r) 
	        { 
	            // Find the middle point 
	            int m = (l+r)/2; 
	  
	            // Sort first and second halves 
	            sort(arr, l, m); 
	            sort(arr , m+1, r); 
	  
	            // Merge the sorted halves 
	            merge(arr, l, m, r); 
	        } 
	    }
	    
	    
	    public void sortar(int im[],String nom[][]) 
	    { 
	        
	       
	    }
	    
	    public int indf(String tar) {
	    	int index=-1;
	    	for (int i=0;i<anim.length;i++) {
	    	    if (anim[i].equals(tar)) {
	    	        index = i;
	    	        break;
	    	    }
	    	}
	    	return index;
	    }
	    
	    
	    
}
